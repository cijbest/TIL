package com.example.p667;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // 내가 permission 받고 싶은 것을 배열로 담음
        String [] permission = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        // 사용자에게 permission 요청(창이 뜸)
        ActivityCompat.requestPermissions(this, permission, 101);
        // permission이 거부되었을 때 앱을 꺼버리도록 설정
        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "Finish", Toast.LENGTH_LONG).show();
            finish();
        }

        MyLocation myLocation = new MyLocation();
        // locationManager의 기능 중 LOCATION_SERVICE를 쓰겠음
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // location 정보 요청
        locationManager.requestLocationUpdates(
                // GPS_PROVIDER : 현재 위치정보 줌
                LocationManager.GPS_PROVIDER,
                // 1초 마다 업데이트
                1,
                // 조금만 움직여도 위치 정보를 줌(0m마다)
                0,
                // 정보는 myLocation이 받음
                myLocation
        );
    }

    public void ck(View v){
        startMyLocation();
    }

    private void startMyLocation() {
        Location location = null;
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, "Finish", Toast.LENGTH_LONG).show();
            finish();
        }
        location = locationManager.getLastKnownLocation(
                LocationManager.GPS_PROVIDER
        );
        if (location != null) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            textView.setText(lat + " " + lon);
        }
    }

    class MyLocation implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            textView.setText(lat + " " + lon);
        }
    }

}