package com.moyu.android60demo;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnCallPhone;
    private Button btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCallPhone = findViewById(R.id.btn_callphone);
        btnWrite = findViewById(R.id.btn_callphone);

        btnCallPhone.setOnClickListener(this);
        btnWrite.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_callphone:
                  CallPhone();
                break;
            case R.id.btn_write:
                   Write();
                break;
        }

    }

    private void Write() {
       if(hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
           RequestPermission(Constants.WRITE_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE);
       }else{
           doWrite();
       }
    }

    private void CallPhone() {
         if(hasPermission(Manifest.permission.CALL_PHONE)){
             RequestPermission(Constants.CALL_PHONE,Manifest.permission.CALL_PHONE);
         }else{
             doCallPhone();
         }
    }

    @Override
    public void doCallPhone() {
        super.doCallPhone();
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + "10010");
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    public void doWrite() {
        super.doWrite();
        Toast.makeText(this, "是否写SDCard权限没有授予", Toast.LENGTH_SHORT).show();
    }
}
