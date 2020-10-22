package com.example.ws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;

    BroadcastReceiver broadcastReceiver; // 브로드캐스트 수신 받음
    IntentFilter intentFilter; // 어떤 브로드캐스트 수신을 받을지 정함

    ImageView imageView2;

    TextView tx;
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        // 상단 ActionBar 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment2 = new Fragment2();


        // 전화 걸기, 네트워크 연결 유무 그림 표시

        imageView2 = findViewById(R.id.imageView2);

        String permissions[] = {
                Manifest.permission.CALL_PHONE
        };
        ActivityCompat.requestPermissions(this, permissions, 101);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = PermissionChecker.checkSelfPermission(ThirdActivity.this, Manifest.permission.CALL_PHONE);
                if(check == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9090-9898"));
                    startActivity(intent);
                }else{
                    Toast.makeText(ThirdActivity.this, "DENIED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // FCM
        tx = findViewById(R.id.tx);

        FirebaseMessaging.getInstance().subscribeToTopic("car").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "FCM Complete ...";
                if(! task.isSuccessful()){
                    msg = "FCM Fail";
                }
                Log.d("[TAG]:", msg);
            }
        });

        // MyFService에서 보낸 데이터 받기
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.registerReceiver(receiver, new IntentFilter("notification"));

    } // end onCreate


    // fragment로 화면 전환
    public void ckbt(View v){
        if(v.getId() == R.id.button2){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment, fragment1
            ).commit();

        } else if(v.getId() == R.id.button3){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragment, fragment2
            ).commit();
        }
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String title = intent.getStringExtra("title");
            String control = intent.getStringExtra("control");
            String data = intent.getStringExtra("data");
            String body = intent.getStringExtra("body");

            //Toast.makeText(ThirdActivity.this, title + " " + control + " " + data + " " + body, Toast.LENGTH_SHORT).show();
            tx.setText("★ " + title+ " : " + body);

            // 진동
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if(Build.VERSION.SDK_INT >= 26){
                vibrator.vibrate(VibrationEffect.createOneShot(1000, 10));
            }else{
                vibrator.vibrate(1000);
            }

//            // 소리
//            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);
//            ringtone.play();

            //notificaiton
            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = null;
            if(Build.VERSION.SDK_INT >= 26){
                if(manager.getNotificationChannel("ch1") == null){
                    manager.createNotificationChannel(new NotificationChannel("ch1", "chname", NotificationManager.IMPORTANCE_DEFAULT));
                }
                builder = new NotificationCompat.Builder(ThirdActivity.this, "ch1");
            }else{
                builder = new NotificationCompat.Builder(ThirdActivity.this);
            }
            builder.setContentTitle(title);
            builder.setContentText(body);
            builder.setSmallIcon(R.drawable.micon);
            Notification noti = builder.build();
            manager.notify(1, noti);


        }
    };
}