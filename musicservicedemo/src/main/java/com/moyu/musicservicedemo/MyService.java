package com.moyu.musicservicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

import static com.moyu.musicservicedemo.MainActivity.path;

public class MyService extends Service {


    private MediaPlayer mediaPlayer;
    private String path= MainActivity.path;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }
            });
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int log = intent.getIntExtra("log", -1);
        switch (log) {
            case 0:
                play();
                break;
            case 1:
                pause();
                break;
            case 2:
                stop();
                break;

            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void stop() {

        if(mediaPlayer!=null){
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void pause() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    private void play() {
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
//            停止播放
            mediaPlayer.stop();
//            释放资源
            mediaPlayer.release();
        }
        super.onDestroy();
    }

}
