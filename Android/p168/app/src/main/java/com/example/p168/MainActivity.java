package com.example.p168;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setVisibility(View.INVISIBLE);
    }

    public void onClickBtns(View v){
        if(v.getId() == R.id.button){
            imageView.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
        }else if(v.getId() == R.id.button2){
            imageView.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.VISIBLE);
        }
    }
}