package com.wangou.robot.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wangou.robot.R;
import com.wangou.robot.adapter.ListItemAdapter;
import com.wangou.robot.entity.Response;
import com.wangou.robot.listener.RequestDataCallBack;
import com.wangou.robot.utils.MyDBHelper;
import com.wangou.robot.utils.NetworkUtils;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.fragment_robot)
public class RobotFragment extends BaseFragment {
    @ViewInject(R.id.srl)
    private SwipeRefreshLayout srl;

    @ViewInject(R.id.listView)
    private ListView listView;

    @ViewInject(R.id.msg_input)
    private AppCompatEditText msgInput;

    private ListItemAdapter mAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initViews() {
        mAdapter = new ListItemAdapter(mContext);
        listView.setAdapter(mAdapter);
        srl.setColorSchemeColors(Color.RED, Color.GREEN);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                hideShowing();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.setDatas(MyDBHelper.getDbHelper().getResponses());
        listView.setSelection(listView.getCount() - 1);
    }

    /**
     * 隐藏加载
     */
    private void hideShowing() {
        if (srl.isRefreshing()) {
            srl.setRefreshing(false);
        }
    }

    @Override
    protected void initDatas(Bundle arguments) {

    }

    @Event(value = R.id.btn_send)
    private void sendMessage(View view) {
        String msg = msgInput.getText().toString().trim();
        Response response = new Response(false, msg);
        saveInfo(response);
        Callback.Cancelable cancelable = NetworkUtils.getNetworkUtil().
                sendMessage(msg, new RequestDataCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        Response response = new Gson().fromJson(result, Response.class);
                        saveInfo(response);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }
                });
    }

    private void saveInfo(Response response) {
        MyDBHelper.getDbHelper().saveInfo(response);
        mAdapter.setDatas(MyDBHelper.getDbHelper().getResponses());
        listView.setSelection(listView.getCount() - 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.clearDatas();
    }
}
