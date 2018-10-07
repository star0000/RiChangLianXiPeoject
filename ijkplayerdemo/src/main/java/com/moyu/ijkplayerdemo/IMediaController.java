package com.moyu.ijkplayerdemo;

import android.view.View;
import android.widget.MediaController;

/**
 * Created by 墨羽 on 2018/3/30.
 */

public interface IMediaController {

    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean enabled);

    void setMediaPlayer(MediaController.MediaPlayerControl player);

    void show(int timeout);

    void show();

    //----------
    // Extends
    //----------
    void showOnce(View view);

}
