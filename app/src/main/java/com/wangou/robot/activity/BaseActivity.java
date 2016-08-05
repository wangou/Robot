package com.wangou.robot.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.wangou.robot.R;
import com.wangou.robot.constant.Constant;
import com.wangou.robot.utils.ToastUtil;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected  Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.ACTION_FINISH);
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        LocalBroadcastManager.getInstance(x.app()).registerReceiver(mReceiver, intentFilter);
        x.view().inject(this);
        mContext=this;
        initDatas(getIntent());
        initViews();
    }

    protected abstract void initViews();

    protected abstract void initDatas(Intent intent);

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Constant.ACTION_FINISH.equals(action)) {
                BaseActivity.this.finish();
            } else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
                ConnectivityManager connectivityManager = (ConnectivityManager)
                        context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = connectivityManager.getActiveNetworkInfo();
                if (info == null || !info.isAvailable()) {
                    ToastUtil.showToastShort(getString(R.string.net_no));
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(x.app()).unregisterReceiver(mReceiver);
    }
}
