package com.example.webviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.path_et)
    EditText pathEt;
    @BindView(R.id.search)
    Button search;
    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.refresh)
    Button refresh;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.pro)
    ProgressBar pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        search.setOnClickListener(this);


        initwebViewClient();
        initwebViewSetting();
    }


    private void initwebViewClient() {
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        web.requestFocus();

        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pro.setVisibility(View.VISIBLE);
                pro.setProgress(newProgress);
                if(newProgress == 100){
                    pro.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

    }


    private void initwebViewSetting() {
        WebSettings webSet = web.getSettings();
        webSet.setJavaScriptEnabled(true);
        webSet.setSupportZoom(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                String pathString = pathEt.getText().toString().trim();
                if (TextUtils.isEmpty(pathString)) {
                    Toast.makeText(MainActivity.this, "不能输入为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                web.loadUrl("http://" + pathString);
                break;

            case R.id.add:
                if (web.canGoForward()) {
                    web.goForward();
                } else {
                    Toast.makeText(this, "没有网页可以前进了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back:
                if (web.canGoBack()) {
                    web.goBack();
                } else {
                    Toast.makeText(this, "没有网页可以后退了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.refresh:
                web.reload();
                break;
        }
    }
}
