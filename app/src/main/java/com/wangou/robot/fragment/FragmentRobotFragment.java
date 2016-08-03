package com.wangou.robot.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wangou.robot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class FragmentRobotFragment extends Fragment {

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.msg_input)
    AppCompatEditText msgInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_robot, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_send)
    void onBtnSendClick() {
        //TODO implement
    }

    @OnLongClick(R.id.btn_send)
    boolean onBtnSendLongClick() {
        //TODO implement
        return true;
    }
}
