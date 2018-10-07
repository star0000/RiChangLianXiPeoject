package com.moyu.service_playmusic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public MyInterface myInterface;
    private ServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bind(View view) {

        Intent intent = new Intent(this, MyService.class);
        serviceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
               myInterface = (MyInterface)service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }

    public void playnext(View view) {
        myInterface.next();
    }

    public void unbind(View view) {
        unbindService(serviceConnection);
    }


}
