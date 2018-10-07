package com.moyu.service_playmusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 墨羽 on 2018/3/12.
 */

public class MyService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wsf", "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("wsf", "onBind");
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        Log.i("wsf", "onDestroy");
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder implements MyInterface{

        @Override
        public void next() {
            Log.e("wsf", "调用了秘书里的下一首方法");
        }
    }


}
