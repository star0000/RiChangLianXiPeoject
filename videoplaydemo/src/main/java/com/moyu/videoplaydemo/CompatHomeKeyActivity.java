package com.moyu.videoplaydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

public class CompatHomeKeyActivity extends AppCompatActivity {

    private HomeKeyWatcher mHomeKeyWatcher;
    private boolean pressedHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHomeKeyWatcher = new HomeKeyWatcher(this);
        mHomeKeyWatcher.setOnHomePressedListener(new HomeKeyWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                pressedHome = true;
            }
        });
        pressedHome = false;
        mHomeKeyWatcher.startWatch();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在OnStop中是release还是suspend播放器，需要看是不是因为按了Home键
        if (pressedHome) {
            NiceVideoPlayerManager.instance().suspendNiceVideoPlayer();
        } else {
            NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
        }
        mHomeKeyWatcher.stopWatch();
    }

    @Override
    protected void onRestart() {
        mHomeKeyWatcher.startWatch();
        pressedHome = false;
        super.onRestart();
        NiceVideoPlayerManager.instance().resumeNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
    }
}
