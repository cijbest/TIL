package com.example.p458;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient()); // 안드로이드에서 기본적으로 제공(웹 렌더링)

        WebSettings webSettings = webView.getSettings(); // 브라우저 기능에 무언 갈 추가
        webSettings.setJavaScriptEnabled(true); // 자바스크립트 허용

        String permissions[] = {

        };

    }

    public void ckbt(View v){
        if(v.getId() == R.id.button){
            webView.loadUrl("http://m.naver.com");
        }else if(v.getId() == R.id.button2){
            webView.loadUrl("http://m.daum.net");
        }else if(v.getId() == R.id.button3){
            webView.loadUrl("http://172.30.1.27/android");
        }
    }
}