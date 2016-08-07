package com.wangou.robot.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.TextView;

import com.wangou.robot.R;
import com.wangou.robot.adapter.ListItemAdapter;
import com.wangou.robot.constant.Constant;
import com.wangou.robot.entity.Response;
import com.wangou.robot.listener.RequestDataCallBack;
import com.wangou.robot.utils.MyDBHelper;
import com.wangou.robot.utils.NetworkUtils;
import com.wangou.robot.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;
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
        msgInput.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                        if (id == EditorInfo.IME_ACTION_SEND
                                || (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                            sendMessage(null);
                            return true;
                        }
                        return false;
                    }
                }

        );
        mAdapter = new

                ListItemAdapter(mContext);

        listView.setAdapter(mAdapter);
        srl.setColorSchemeColors(Color.RED, Color.GREEN);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()

                                 {
                                     @Override
                                     public void onRefresh() {
                                         srl.setRefreshing(true);
                                         hideShowing();
                                     }
                                 }

        );
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
        if (TextUtils.isEmpty(msg)) {
            ToastUtil.showToastShort(R.string.not_null);
            return;
        }
        msgInput.setText("");
        Response response = new Response(msg, false);
        saveInfo(response);
        Callback.Cancelable cancelable = NetworkUtils.getNetworkUtil().
                sendMessage(msg, new RequestDataCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("result", result);
                        try {
                            JSONObject object = new JSONObject(result);
                            int code = object.getInt("code");
                            Response response;
                            if (Constant.CODE_RESPONSE_TEXT == code) {
                                String msg = object.getString("text");
                                response = new Response(msg, true);
                            } else {
                                response = new Response(result, code);
                            }
                            saveInfo(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
