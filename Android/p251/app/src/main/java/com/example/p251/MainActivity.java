package com.example.p251;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ckbt(View v){
        // SecondActivity로 이동
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

        // SecondActivity에 데이터 전달
        intent.putExtra("data",100); // second activity에 값을 전달
        intent.putExtra("str", "String Data");

        startActivity(intent);
    }
}