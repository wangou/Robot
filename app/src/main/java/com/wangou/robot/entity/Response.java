package com.wangou.robot.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/8/5.
 */
@Table(name = "result")
public class Response {
    @Column(name = "id", isId = true, property = "PRIMARY KEY AUTOINCREMENT")
    private int id;

    @Column(name = "isCom")
    private boolean isCom = true;

    @Column(name = "result")
    private String result;

    @Column(name = "code")
    private int code=100000;

    public Response(String result, boolean isCom) {
        this.result = result;
        this.isCom = isCom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCom() {
        return isCom;
    }

    public void setCom(boolean com) {
        isCom = com;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response(String result, int code) {

        this.result = result;
        this.code = code;
    }

    public Response() {

    }
}
