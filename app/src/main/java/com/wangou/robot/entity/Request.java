package com.wangou.robot.entity;

import com.wangou.robot.Application.MyApplication;
import com.wangou.robot.constant.HttpUrl;

/**
 * Created by Administrator on 2016/8/5.
 */
public class Request {
    private String key;
    private String info;
    private String userid;

    public Request() {
    }

    public Request(String info) {
        setKey(HttpUrl.API_KEY);
        setUserid(MyApplication.getApp().getImei());
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
