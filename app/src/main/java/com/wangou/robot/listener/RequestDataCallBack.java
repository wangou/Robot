package com.wangou.robot.listener;

/**
 * 网络请求回调接口
 */
public interface RequestDataCallBack {
    void onSuccess(String result);

    void onError(Throwable ex, boolean isOnCallback);
}