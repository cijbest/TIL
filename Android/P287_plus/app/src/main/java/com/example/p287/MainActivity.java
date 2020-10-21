package com.example.p287;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements Fragment1.View1Manager {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] permission = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        ActivityCompat.requestPermissions(this,
                permission, 101);



//        fragment1 = new Fragment1();
        fragment1 =
                (Fragment1)getSupportFragmentManager().findFragmentById(
                        R.id.fragment
                );
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        actionBar = getSupportActionBar();
        actionBar.setTitle("Fragment");
        actionBar.setLogo(R.drawable.d1);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_USE_LOGO);
        //actionBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.m1){
            Log.d("-----------------------","--------------------------------");
            changeTx("dd");
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment1
            ).commit();
        }else if(item.getItemId() == R.id.m2){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment2
            ).commit();
        }else if(item.getItemId() == R.id.m3){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment3
            ).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    public void ckbt(View v){
        if(v.getId() == R.id.button){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment1
            ).commit();
        }else if(v.getId() == R.id.button2){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment2
            ).commit();
        }else if(v.getId() == R.id.button3){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment,fragment3
            ).commit();
        }
    }

    @Override
    public void changeTx(String str) {
        fragment1.setTx(str);

    }
}




