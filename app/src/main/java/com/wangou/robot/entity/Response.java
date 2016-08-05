package com.wangou.robot.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2016/8/5.
 */
@Table(name = "response")
public class Response {
    @Column(name = "id", isId = true, property = "PRIMARY KEY AUTOINCREMENT")
    private int id;
    @Column(name = "isCom")
    private boolean isCom = true;
    @Column(name = "code")
    private int code;
    @Column(name = "text")
    private String text;
    @Column(name = "url")
    private String url;
    @Column(name = "list")
    private String list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Response(boolean isCom, String text) {
        this.isCom = isCom;
        this.text = text;
    }

    public boolean isCom() {
        return isCom;
    }

    public void setCom(boolean com) {
        isCom = com;
    }

    public Response(int code, String text, String url, String list) {
        this.code = code;
        this.text = text;
        this.url = url;
        this.list = list;
    }

    public Response() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
