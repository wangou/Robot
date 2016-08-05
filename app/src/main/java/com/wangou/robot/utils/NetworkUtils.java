package com.wangou.robot.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.wangou.robot.constant.HttpUrl;
import com.wangou.robot.entity.Request;
import com.wangou.robot.listener.RequestDataCallBack;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;

/**
 * 网络请求工具类
 */
public class NetworkUtils {
    private static NetworkUtils networkUtil;

    private NetworkUtils() {

    }


    public static NetworkUtils getNetworkUtil() {
        synchronized (NetworkUtils.class) {
            if (networkUtil == null) {
                networkUtil = new NetworkUtils();
            }
        }
        return networkUtil;
    }

    /**
     * Post请求
     *
     * @param params
     */
    public Callback.Cancelable doPost(RequestParams params, final RequestDataCallBack callBack) {
        return x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ex", ex.getMessage());
                callBack.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    /**
     * Get请求
     *
     * @param params
     * @param callBack
     */
    public Callback.Cancelable doGet(RequestParams params, final RequestDataCallBack callBack) {
        return x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ex", ex.getMessage());
                callBack.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    /**
     * Delete请求
     *
     * @param params
     * @param callBack
     */
    public Callback.Cancelable doDelete(RequestParams params, final RequestDataCallBack callBack) {
        return x.http().request(HttpMethod.DELETE, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ex", ex.getMessage());
                callBack.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    /**
     * Put请求
     *
     * @param params
     * @param callBack
     */
    public Callback.Cancelable doPut(RequestParams params, final RequestDataCallBack callBack) {
        return x.http().request(HttpMethod.PUT, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("ex", ex.getMessage());
                callBack.onError(ex, isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

    public Callback.Cancelable sendMessage(String msg, final RequestDataCallBack callBack) {
        RequestParams params = new RequestParams(HttpUrl.API_URL);
        params.setAsJsonContent(true);
        params.setCharset("utf-8");
        Request request = new Request(msg);
        params.setBodyContent(new Gson().toJson(request));
        return doPost(params, callBack);
    }

    /**
     * 取消请求
     *
     * @param cancelables
     */
    public void cancelRequest(List<Callback.Cancelable> cancelables) {
        if (cancelables == null || cancelables.size() == 0) {
            return;
        }
        for (Callback.Cancelable cancelable : cancelables) {
            if (cancelable != null && !cancelable.isCancelled()) {
                cancelable.cancel();
            }
        }
    }

    /**
     * 取消请求
     *
     * @param cancelable
     */
    public void cancelRequest(Callback.Cancelable cancelable) {
        if (cancelable == null) {
            return;
        }
        if (!cancelable.isCancelled()) {
            cancelable.cancel();
        }
    }

    /**
     * 上传文件
     *
     * @param file
     * @param callBack
     */
    public void uploadFile(File file, RequestDataCallBack callBack) {
//        String token = AppUtil.getToken();
//        RequestParams params = new RequestParams(Constant.URL_FILE_UPLOAD);
//        params.addBodyParameter(Constant.FILE, file);
//        params.addBodyParameter(Constant.T, token);
//        doPost(params, callBack);
    }
}
