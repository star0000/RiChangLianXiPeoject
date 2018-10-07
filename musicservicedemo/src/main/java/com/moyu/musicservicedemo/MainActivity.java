package com.moyu.musicservicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.et_path)
    EditText etPath;
    @BindView(R.id.startplay)
    Button startplay;
    @BindView(R.id.pauseplay)
    Button pauseplay;
    @BindView(R.id.stopplay)
    Button stopplay;
    private Intent intent;
    public static String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startplay.setOnClickListener(this);
        pauseplay.setOnClickListener(this);
        stopplay.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        intent = new Intent(this, MyService.class);
        path = etPath.getText().toString().trim();
//        if(TextUtils.isEmpty(path)){
//            Toast.makeText(this,"不能为空!",Toast.LENGTH_SHORT).show();
//            return;
//        }
        File file = new File(path);
//        if(!file.exists()){
//            Toast.makeText(this,"不能为空!",Toast.LENGTH_SHORT).show();
//            return;
//        }

        switch (v.getId()) {
            case R.id.startplay:
                intent.putExtra("log", 0);
                break;
            case R.id.pauseplay:
                intent.putExtra("log", 1);
                break;
            case R.id.stopplay:
                intent.putExtra("log", 2);
                stopService(intent);
                break;
        }
        startService(intent);
    }

}
