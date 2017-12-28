package com.example.macbookpro.mvp.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.example.macbookpro.mvp.R;
import com.example.macbookpro.mvp.base.BaseActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

import butterknife.Bind;

public class OneActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.text)
    TextView text;
    private String stringExtra1;

    @Override
    protected void initData() {
        initToo();
        Intent intent = getIntent();
        final String stringExtra = intent.getStringExtra("002");
        stringExtra1 = intent.getStringExtra("001");
        text.setText(stringExtra1);
        webView.loadUrl(stringExtra);
        //显示网站
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(stringExtra);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        button.setOnClickListener(this);
    }
    public void initToo(){
        toolbar.setNavigationIcon(R.mipmap.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_one;
    }

    //这是页面回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                getDaiMianBan();
                break;
        }
    }
    //面板分享
    private void getDaiMianBan() {
        new ShareAction(OneActivity.this)
                .withText("hello")
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                .setCallback(umShareListener)
                .withMedia(new UMImage(OneActivity.this, R.mipmap.ic_launcher))
                .open();
    }

    //分享的监听
    UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart", "onStart");
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Log.e("onResult", "onResult");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Log.e("onError", "onError");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Log.e("onCancel", "onCancel");
        }
    };
}
