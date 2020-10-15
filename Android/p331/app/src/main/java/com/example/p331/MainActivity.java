package com.example.p331;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView = null;
    ActionBar actionBar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    FragmentManager fragmentManager;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1(this);
        fragment2 = new Fragment2(this);
        fragment3 = new Fragment3(this);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit(); // 최초에 fragment1을 띄우겠다.

        actionBar = getSupportActionBar();
        actionBar.hide();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1){
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment1).commit();
                    Toast.makeText(MainActivity.this, "tab1", Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.tab2){
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment2).commit();
                    Toast.makeText(MainActivity.this, "tab2", Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.tab3){
                    fragmentManager.beginTransaction().replace(R.id.framelayout, fragment3).commit();
                    Toast.makeText(MainActivity.this, "tab3", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}