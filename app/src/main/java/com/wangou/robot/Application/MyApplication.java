package com.wangou.robot.Application;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.telephony.TelephonyManager;

import com.wangou.robot.constant.Constant;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2016/8/1.
 */
public class MyApplication extends Application {

    private DbManager.DaoConfig daoConfig;

    private static MyApplication app;

    private String imei;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        x.Ext.init(this);
        x.Ext.setDebug(false); // 是否输出debug日志, 开启debug会影响性能.
        initDbConfig();
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }

    public String getImei() {
        return imei;
    }

    public static MyApplication getApp() {
        return app;
    }

    private void initDbConfig() {
        daoConfig = new DbManager.DaoConfig()
                .setDbName(Constant.DB_NAME)
                // 不设置dbDir时, 默认存储在app的私有目录.
                .setDbDir(new File(getCachePath()))
                .setDbVersion(7)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        if (oldVersion < 7) {
                            try {
                                db.dropDb();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    public DbManager.DaoConfig getDaoConfig() {
        return daoConfig;
    }

    /**
     * 缓存路径
     *
     * @return
     */
    public String getCachePath() {
        String cachePath;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cachePath = Environment.getExternalStorageDirectory() + Constant.APP_DIR;
        } else {
            cachePath = getCacheDir().getPath() + Constant.APP_DIR;
        }
        File file = new File(cachePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return cachePath;
    }
}
