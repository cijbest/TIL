package com.example.ws;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tx_id, tx_pwd;
    HttpAsync httpAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 상단 ActionBar 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tx_id = findViewById(R.id.tx_id);
        tx_pwd = findViewById(R.id.tx_pwd);

    }

    // 로그인 버튼
    public void ck(View v) {
        String id = tx_id.getText().toString();
        String pwd = tx_pwd.getText().toString();
        String url = "http://172.30.1.27/android/login.jsp";
        url += "?id="+id+"&pwd="+pwd;
        httpAsync = new HttpAsync();
        httpAsync.execute(url);

    }

    // 로그인 실행
    class HttpAsync extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(SecondActivity.this);
            progressDialog.setTitle("Login ...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0].toString();
            String result = HttpConnect.getString(url); // 정보가 맞으면 0, 틀리면 1값이 들어온다
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            String result = s.trim(); // 혹시 모를 불필요한 데이터가 있을걸 대비해서 처리
            if(result.equals("1")){ // 로그인 성공
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }else { // 로그인 실패
                AlertDialog.Builder dailog = new AlertDialog.Builder(SecondActivity.this);
                dailog.setTitle("LOGIN FAIL");
                dailog.setMessage("Try Again...");
                dailog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dailog.show();

            }
            //Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}