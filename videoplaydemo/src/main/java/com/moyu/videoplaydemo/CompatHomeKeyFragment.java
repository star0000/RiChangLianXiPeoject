package com.moyu.videoplaydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

/**
 * Created by 墨羽 on 2018/3/22.
 */

public class CompatHomeKeyFragment extends Fragment {

    private HomeKeyWatcher mHomeKeyWatcher;
    private boolean pressedHome;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHomeKeyWatcher = new HomeKeyWatcher(getActivity());
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
    public void onStart() {
        super.onStart();
        mHomeKeyWatcher.startWatch();
        pressedHome = false;
        super.onStart();
        NiceVideoPlayerManager.instance().resumeNiceVideoPlayer();
    }

    @Override
    public void onStop() {
        // 在OnStop中是release还是suspend播放器，需要看是不是因为按了Home键
        if (pressedHome) {
            NiceVideoPlayerManager.instance().suspendNiceVideoPlayer();
        } else {
            NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
        }
        super.onStop();
        mHomeKeyWatcher.stopWatch();
    }
}
