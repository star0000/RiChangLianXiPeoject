package com.fyts.guojihuademo;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by 墨羽 on 2018/4/26.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiLanguageUtil.init(this);
//        MultiLanguageUtil.getInstance().setConfiguration();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
//                MultiLanguageUtil.getInstance().setConfiguration();
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        MultiLanguageUtil.getInstance().setConfiguration();
    }


}
