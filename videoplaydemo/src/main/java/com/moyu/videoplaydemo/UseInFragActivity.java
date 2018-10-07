package com.moyu.videoplaydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

public class UseInFragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_in_frag);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new DemoFragenment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
    }
}
