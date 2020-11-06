package com.example.tcpip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.msg.Msg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    TextView tx_list, tx_msg;
    EditText et_ip, et_msg;

    int port;
    String address;
    String id;
    Socket socket;

    Sender sender;

    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx_list = findViewById(R.id.tx_list);
        tx_msg = findViewById(R.id.tx_msg);
        et_ip = findViewById(R.id.et_ip);
        et_msg = findViewById(R.id.et_msg);

        FirebaseMessaging.getInstance().subscribeToTopic("aaa").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                String msg = "FCM Complete ...";
                if(! task.isSuccessful()){
                    msg = "FCM Fail";
                }
                Log.d("[TAG]:", msg);
            }
        });


        port = 5555;
        address = "192.168.0.17";
        id = "[Ella]";
        new Thread(con).start();

        // FcmTest에서 보낸 데이터 받기
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.registerReceiver(receiver, new IntentFilter("notification"));


    }



    // 앱 나갈 때
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try{
            Msg msg = new Msg(null, id, "q");
            sender.setMsg(msg);
            new Thread(sender).start();
            if(socket != null){
                socket.close();
            }
            finish();
            onDestroy();

        }catch (Exception e){

        }

    }

    Runnable con = new Runnable() {
        @Override
        public void run() {
            try {
                connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private void connect() throws IOException {
        try {
            socket = new Socket(address, port);
        } catch (Exception e) {
            while(true) {
                try {
                    Thread.sleep(2000);
                    socket = new Socket(address, port);
                    break;
                } catch (Exception e1) {
                    System.out.println("Retry ...");
                }
            }
        }
        System.out.println("Connected Server: " + address);
        sender = new Sender(socket);
        new Receiver(socket).start();
        getList();
    }

    private void getList() {
        Msg msg = new Msg(null, "[Jean]","1");
        sender.setMsg(msg);
        new Thread(sender).start();

    }

    public void clickBt(View v){
        String txip = et_ip.getText().toString();
        String txmsg = et_msg.getText().toString();

        Msg msg = null;
        if(txip == null || txip.equals("")){ // 전체 메세지
            msg = new Msg(id,txmsg);
        }else{ // 귓속말 메시지
            ArrayList<String> ips = new ArrayList<>();
            ips.add(txip);
            msg = new Msg(ips, id, txmsg);
        }
        sender.setMsg(msg);
        new Thread(sender).start();


    }

    class Receiver extends Thread {
        ObjectInputStream oi;
        public Receiver(Socket socket) throws IOException {
            oi = new ObjectInputStream(socket.getInputStream());
        }
        @Override
        public void run() {
            while(oi != null) {
                Msg msg = null;
                try {
                    msg = (Msg) oi.readObject();
                    if(msg.getMaps() != null) {
                        HashMap<String, Msg> hm = msg.getMaps();
                        Set<String> keys = hm.keySet();
                        for(final String k : keys) {
                            // list에 ip주소 추가
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String tx = tx_list.getText().toString();
                                    tx_list.setText(tx + k +"\n");
                                }
                            });
                            System.out.println(k);
                        }
                        continue;
                    }

                    Msg finalMsg = msg;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String tx = tx_msg.getText().toString();
                            tx_msg.setText(finalMsg.getId() + finalMsg.getMsg() +"\n"+tx);
                        }
                    });
                    System.out.println(msg.getId() + msg.getMsg());
                } catch(Exception e) {
                    //e.printStackTrace();
                    break;
                }

            } // end while

            try {
                if(oi != null) {
                    oi.close();
                }
                if(socket != null) {
                    socket.close();
                }
            } catch(Exception e) {

            }
        }

    }

    class Sender implements Runnable {
        Socket socket;
        ObjectOutputStream oo;
        Msg msg;

        public Sender (Socket socket) throws IOException {
            this.socket = socket;
            oo = new ObjectOutputStream(socket.getOutputStream());
        }
        public void setMsg(Msg msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            if(oo != null) {
                try {
                    oo.writeObject(msg);
                    et_msg.setText(""); // 채팅 입력창 비우기
                } catch (IOException e) {
                    // 서버가 죽어 있을 때
                    // 더 이상의 메세지가 날라가지 않을 때 에러가 난다.
                    //e.printStackTrace();

                    try {
                        if(socket != null) {
                            socket.close();
                        }
                    }catch(Exception e1){
                        e1.printStackTrace();
                    }

                    try {
                        // 다시 서버와 연결 시도
                        System.out.println("Retry ...");
                        Thread.sleep(2000);
                        connect();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } // end try
            }
        }
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            intent.getStringExtra("title");
            String title = intent.getStringExtra("title");
            String control = intent.getStringExtra("control");
            String data = intent.getStringExtra("data");
            String body = intent.getStringExtra("body");
            Toast.makeText(MainActivity.this, title + " " + control + " " + data + " " + body, Toast.LENGTH_SHORT).show();

            // notification
            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = null;
            if(Build.VERSION.SDK_INT >= 26){
                if(manager.getNotificationChannel("ch1") == null){
                    manager.createNotificationChannel(new NotificationChannel("ch1", "chname", NotificationManager.IMPORTANCE_DEFAULT));
                }
                builder = new NotificationCompat.Builder(MainActivity.this, "ch1");
            }else{
                builder = new NotificationCompat.Builder(MainActivity.this);
            }
            builder.setContentTitle(title);
            builder.setContentText(body);
            builder.setSmallIcon(R.drawable.rabbit);
            Notification noti = builder.build();
            manager.notify(1, noti);

//            // 진동
//            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//            if(Build.VERSION.SDK_INT >= 26){
//                vibrator.vibrate(VibrationEffect.createOneShot(1000, 10));
//            }else{
//                vibrator.vibrate(1000);
//            }

            // 소리
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);
            ringtone.play();


        }
    };
}