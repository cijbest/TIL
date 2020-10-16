package com.example.p489;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button, button2;
    SeekBar seekBar;
    TextView textView;
    ImageView imageView;
    MyAsynch myAsynch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setEnabled(true);
        button2.setEnabled(false);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
    }
    public void ckbt1(View v){
        myAsynch = new MyAsynch();
        myAsynch.execute(100); // doInBackgroud 실행

    }
    public void ckbt2(View v){
        myAsynch.cancel(true); // asychtask 중단
        myAsynch.onCancelled();
        button.setEnabled(true);
        button2.setEnabled(false);
    }

    // 첫번째 Integer : doInBackgroud 메소드 시작 시(스레드 시작할 때) 넣는 값
    // 두번째 Integer : 던지는 타입을 Integer
    // String : 스레드가 끝나면 반환하는 값의 타입
    class MyAsynch extends AsyncTask<Integer, Integer, String> {
        @Override
        protected void onPreExecute() { // doInBackground를 실행하기 전에 실행
            // 버튼을 눌렀을 시점에 배치하지 않는 이유 : 스레드이기 때문에 바로 실행이 된다. 잘못될 수 있음.
            button.setEnabled(false);
            button2.setEnabled(true);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int a = integers[0].intValue();
            int sum = 0;
            for(int i = 0 ; i <= a ; i++){
                if(isCancelled() == true){
                    break;
                }
                sum += i;
                publishProgress(i); // 값을 던짐
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "result: " + sum;
        }

        // 스레드가 진행되는 중에 값을 볼 수 있음
        @Override
        protected void onProgressUpdate(Integer... values) { // 던지는 값을 받음 (... : 배열로 받음)
            int i = values[0].intValue(); // 값을 받음, 지금은 값을 하나만 받았으므로 0번째만 가져옴
            seekBar.setProgress(i);
            if(i <= 30){
                imageView.setImageResource(R.drawable.down);
            }else if(i <= 70){
                imageView.setImageResource(R.drawable.mid);
            }else if(i <= 100){
                imageView.setImageResource(R.drawable.up);
            }
        }

        // doInBackground에서 리턴되는 값을 받아옴
        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            // 시크바가 동작을 끝냈을 때도 버튼 상태 변경
            button.setEnabled(true);
            button2.setEnabled(false);
        }

        @Override
        protected void onCancelled() {
            seekBar.setProgress(0);
            textView.setText("");
            imageView.setImageResource(R.drawable.ic_launcher_background);
            // stop 버튼 눌렀을 때, 버튼 상태 변경
            button.setEnabled(true);
            button2.setEnabled(false);
        }
    }
}