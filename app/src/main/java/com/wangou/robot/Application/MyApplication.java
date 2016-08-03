package com.wangou.robot.Application;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;
import com.wangou.robot.constant.HttpUrl;

/**
 * Created by Administrator on 2016/8/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiStoreSDK.init(this, HttpUrl.API_KEY);
    }
}
