package com.wangou.robot.utils;

import com.wangou.robot.Application.MyApplication;
import com.wangou.robot.entity.Response;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * 数据库操作
 */
public class MyDBHelper {
    private static MyDBHelper dbHelper;
    private DbManager dbManager;

    private MyDBHelper() {
        dbManager = x.getDb(MyApplication.getApp().getDaoConfig());
    }

    public static MyDBHelper getDbHelper() {
        synchronized (MyDBHelper.class) {
            if (dbHelper == null) {
                dbHelper = new MyDBHelper();
            }
        }
        return dbHelper;
    }

    public void saveInfo(Object entity) {
        if (entity == null) {
            return;
        }
        try {
            dbManager.save(entity);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void deleteInfo(Class<?> entityType, WhereBuilder whereBuilder) {
        try {
            dbManager.delete(entityType, whereBuilder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void deleteInfoById(Class<?> entityType, Object id) {
        try {
            dbManager.deleteById(entityType, id);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除所有指定类型的数据
     *
     * @param entityType
     */
    public void deleteTypeInfo(Class<?> entityType) {
        try {
            dbManager.delete(entityType);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除表
     *
     * @param entityType
     */
    public void dropTable(Class<?> entityType) {
        try {
            dbManager.dropTable(entityType);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    /**
     * 清除数据库
     */
    public void dropDB() {
        try {
            dbManager.dropDb();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List<Response> getResponses() {
        try {
            return dbManager.findAll(Response.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }
}
