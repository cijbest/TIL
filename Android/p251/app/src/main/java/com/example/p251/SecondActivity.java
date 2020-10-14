package com.example.p251;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // MainActivity에서 넘겨준 값 받기
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras(); // bundle 사용 시 여러 개의 데이터를 보내기 쉬워짐
        //int result = intent.getIntExtra("data",0);
        int result = bundle.getInt("data",0);
        String str_result = bundle.getString("str", "");
        Toast.makeText(this,""+str_result+":" + result, Toast.LENGTH_SHORT).show();


    }
    public void ckbt(View v){
        // ThirdActivity로 이동
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }
}