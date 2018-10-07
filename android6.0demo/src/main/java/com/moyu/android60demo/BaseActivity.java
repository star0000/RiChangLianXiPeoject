package com.moyu.android60demo;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public boolean hasPermission(String...permissions){
        for ( String permission :permissions) {
             if(ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED){
                 return true;
             }
        }
        return false;
    }

    public void RequestPermission(int code,String...permissions){
        ActivityCompat.requestPermissions(BaseActivity.this,permissions,code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case Constants.CALL_PHONE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else{
                    Toast.makeText(this, "打电话权限没有授予", Toast.LENGTH_SHORT).show();
                }
                break;
            case Constants.WRITE_EXTERNAL_STORAGE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doWrite();
                }else{
                    Toast.makeText(this, "写SDCard权限没有授予", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void doWrite() {

    }

    public void doCallPhone() {

    }
}
