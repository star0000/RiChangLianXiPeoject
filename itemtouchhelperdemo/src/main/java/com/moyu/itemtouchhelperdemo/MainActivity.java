package com.moyu.itemtouchhelperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_drag)
    Button btnDrag;
    @BindView(R.id.btn_channl)
    Button btnChannl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnDrag.setOnClickListener(this);
        btnChannl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_drag:
                startActivity(new Intent(MainActivity.this, DragActivity.class));
                break;
            case R.id.btn_channl:
                startActivity(new Intent(MainActivity.this, ChannelActivity.class));
                break;
        }
    }
}
