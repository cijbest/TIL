package com.example.p251;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.Permission;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // permission 배열 안에 있는 요청들을 처리
        // requestCode: 101은 지정된 것
        String permissions [] = {
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
    }

    public void ckbt(View v){
        Intent intent = null;
        if(v.getId() == R.id.button3){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-9879-2039"));
            startActivity(intent);
        }else if(v.getId() == R.id.button4){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people")); // 주소록
            startActivity(intent);
        }else if(v.getId() == R.id.button5){
            int check = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if(check == PackageManager.PERMISSION_GRANTED){
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9878-8989"));
                startActivity(intent);
            }else{
                Toast.makeText(this, "Not Allowed", Toast.LENGTH_SHORT).show();
            }


        }
    }
}