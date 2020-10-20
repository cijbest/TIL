package com.example.p552;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 데이터를 간단하게 저장하는 용도
    // 앱을 삭제하지 않는 한 데이터를 계속 저장되어 있음
    // 예시) 로그인 안 해도 자동로그인 할 수 있음
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MODE_PRIVATE : 외부에서 접근하지 못하게 하겠다.
        sp = getSharedPreferences("login", MODE_PRIVATE);
        String status = sp.getString("status", "");
        Toast.makeText(this, status, Toast.LENGTH_LONG).show();
    }

    // SharedPreferences에 데이터 저장
    public void ck(View v){
        // SharedPreferences에 데이터를 저장
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("status","ok");
        edit.commit();
    }

    // SharedPreferences에 저장된 데이터를 삭제
    public void ck2(View v){
        SharedPreferences.Editor edit = sp.edit();
        edit.remove("status");
        edit.commit();
    }
}