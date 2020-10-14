package com.example.p275;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("[TEST]", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("[TEST]", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
        Log.d("[TEST]", "onPurse");
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
        Log.d("[TEST]", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("[TEST]", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveState();
        Log.d("[TEST]", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("[TEST]", "onDestroy");
    }

    // 앱 실행 도중, stop 또는 destroy가 일어날 때 임시로 저장한 데이터 복구
    public void restoreState(){
        sp = getSharedPreferences("st", Activity.MODE_PRIVATE);
        if(sp != null && sp.contains("date")){
            String result = sp.getString("date", "");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }

    // 앱 실행 도중, stop 또는 destroy가 일어날 때 정보를 임시로 저장
    public void saveState(){
        sp = getSharedPreferences("", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Date d = new Date();
        editor.putString("date", d.toString());
        editor.commit();
    }




}