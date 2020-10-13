package com.example.p200;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LinearLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float x = event.getX();
                float y = event.getY();
                if(action == MotionEvent.ACTION_DOWN){ // 화면을 터치했을 때의 이벤트
                    print("DOWN:"+x+","+y);
                }else if(action == MotionEvent.ACTION_MOVE){ // 화면을 문지를 때의 이벤트
                    print("MOVE:"+x+","+y);
                }else if(action == MotionEvent.ACTION_UP){ // 화면에서 손을 뗐을 때의 이벤트
                    print("UP:"+x+","+y);
                }
                return true;
            }
        });
    } // onCreate end

    public void print(String str){
        textView.setText(str);
    }

    @Override
    public void onBackPressed(){  // 뒤로가기 키를 눌렀을 때 실행되는 이벤트
        Toast.makeText(this,"" + "BACK KEY PRESSED",Toast.LENGTH_SHORT).show();
        finish();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) { // 뒤로가기 키를 눌렀을 때 실행되는 이벤트
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            Toast.makeText(this,"" + "BACK KEY PRESSED",Toast.LENGTH_SHORT).show();
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}