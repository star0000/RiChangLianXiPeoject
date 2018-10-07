package com.moyu.greendaodemo;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 墨羽 on 2018/3/21.
 */

public class App extends Application {

    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "users-db-encrypted" : "users-db");
        Database db = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

}
