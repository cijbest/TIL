package com.example.p207;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText et;
    TextView textView;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show("onCreate");
        Log.d("[TEST]", "onCreate");
        button = findViewById(R.id.button);
        et = findViewById(R.id.et);
        textView = findViewById(R.id.textView2);
        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        /*
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                str = et.getText().toString(); // getText는 editText 타입이므로 toString으로 변환시켜 주어야 함

            }
        });
         */
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main);
            //Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
           // Toast.makeText(this, "PORTRAIT", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() { // 앱이 실행될 때
        super.onStart();
        show("onStart");
        Log.d("[TEST]", "onStart");
    }

    @Override
    protected void onStop() { // 앱이 멈출 때
        super.onStop();
        show("onStop");
        Log.d("[TEST]", "onStop");
    }

    @Override
    protected void onDestroy() { // 앱이 꺼질 때
        super.onDestroy();
        show("onDestroy");
        Log.d("[TEST]", "onDestroy");
    }

    public void show(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}