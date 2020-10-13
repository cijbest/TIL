package com.example.p217;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10); // 막대 크기 지정
    }

    public void clickb1(View v){
        Toast t = Toast.makeText(this,"Toast1 ...", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER,0,0); // 정가운데에 위치 고정
        t.show();

    }
    public void clickb2(View v){

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast, (ViewGroup)findViewById(R.id.toast_layout)); // toast.xml을 쓸거고 레이아웃은 toast_layout이다. ViewGroup으로 view 요소를 다 가지고 온다.
        TextView tv = view.findViewById(R.id.textView); // 가지고 온 view요소를 가져다 쓸 수 있게됨
        tv.setText("INPUT TEXT");

        Toast t = new Toast(this);
        t.setGravity(Gravity.CENTER,0,0); // 정가운데에 위치 고정
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(view);
        t.show();
    }
    public void clickb3(View v){
        Snackbar.make(v,"Snack Bar", Snackbar.LENGTH_LONG).show(); // 스낵바 띄우기
    }
    public void clickb4(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // AlertDialog를 activity 위에서 띄운다.
        builder.setTitle("My Dialog");
        builder.setMessage("Are You Exit Now");
        builder.setIcon(R.drawable.dog);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void btprogress(View v){
        ProgressDialog progressDialog = null;
        if(v.getId() == R.id.button5){
            int pdata = progressBar.getProgress();
            if(pdata < 10) {
                progressBar.setProgress(pdata + 1);
            }else{
                Toast.makeText(this, "Max Value", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId() == R.id.button6){
            int pdata = progressBar.getProgress();
            progressBar.setProgress(pdata-1);
        }else if(v.getId() == R.id.button7) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setTitle("Downloading ...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }else if(v.getId() == R.id.button8){
            progressDialog.dismiss(); // 다운로드가 끝나면 해제 처리해주는 부분
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.dialog));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog");
        builder.setMessage("Are You Exit Now");
        builder.setView(view);  // 내가 만든 view 화면
        builder.setIcon(R.drawable.dog);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}