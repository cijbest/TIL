package com.example.p475;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    MyHandler myHandler;
    MyHandler2 myHandler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHandler = new MyHandler();
        myHandler2 = new MyHandler2();

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        Thread t = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread2());
        t.start();
        t2.start();
    }


    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("km", 0);
            textView.setText(data+"km");
        }
    }

    class MyHandler2 extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("rpm", 0);
            textView2.setText(data+"rpm");
        }
    }

    class MyThread implements Runnable{
        Random random = new Random();

        @Override
        public void run() {
            for(int i = 1 ; i < 100; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = myHandler.obtainMessage();
                Bundle bundle = new Bundle();

                bundle.putInt("km", random.nextInt(200)+1);
                message.setData(bundle);
                myHandler.sendMessage(message);

            }
        }
    }
    class MyThread2 implements Runnable{
        Random random = new Random();

        @Override
        public void run() {
            for(int i = 1 ; i < 100; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message message = myHandler2.obtainMessage();
                Bundle bundle = new Bundle();

                bundle.putInt("rpm", random.nextInt(5000)+1);
                message.setData(bundle);
                myHandler2.sendMessage(message);
            }
        }
    }
}