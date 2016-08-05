package com.wangou.robot.utils;

import android.widget.Toast;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/5.
 */
public class ToastUtil {
    public static void showToastShort(String msg) {
        Toast.makeText(x.app(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(String msg) {
        Toast.makeText(x.app(), msg, Toast.LENGTH_LONG).show();
    }

    public static void showToastShort(int msg) {
        showToastShort(x.app().getString(msg));
    }

    public static void showToastLong(int msg) {
        showToastLong(x.app().getString(msg));
    }
}
