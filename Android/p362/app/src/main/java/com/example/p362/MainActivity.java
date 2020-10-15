package com.example.p362;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    BroadcastReceiver broadcastReceiver; // 브로드캐스트 수신 받음
    IntentFilter intentFilter; // 어떤 브로드캐스트 수신을 받을지 정함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        String permissions [] = {
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS
        };
        ActivityCompat.requestPermissions(this, permissions, 101);

        // 등록
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); // 네트워크가 변경되었다는 정보
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED"); // 문자를 받았다는 정보

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String cmd = intent.getAction();
                ConnectivityManager cm = null;
                NetworkInfo mobile = null;
                NetworkInfo wifi = null;

                // 인터넷 연결되었을 때
                if(cmd.equals("android.net.conn.CONNECTIVITY_CHANGE")){
                    // SystemService에서 ConnectivityManager를 사용할 수 있도록 가져옴
                    cm = (ConnectivityManager) context.getSystemService(
                            Context.CONNECTIVITY_SERVICE
                    );
                    mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    if(mobile != null && mobile.isConnected()){ //  모바일 유심

                    }else if(wifi != null && wifi.isConnected()){ // 인터넷 연결 됐을 때
                        imageView.setImageResource(R.drawable.wifi);
                    }else { // 연결이 끊겼을 때
                        imageView.setImageResource(R.drawable.nwifi);
                    }
                // 문자 받았을 때
                }else if(cmd.equals("android.provider.Telephony.SMS_RECEIVED")){
                    Toast.makeText(context, "SMS_RECEIVED", Toast.LENGTH_SHORT).show();
                    Bundle bundle = intent.getExtras();
                    Object[] obj = (Object[]) bundle.get("pdus");
                    SmsMessage[] messages = new SmsMessage[obj.length];
                    for(int i = 0; i < obj.length; i++){
                        String format = bundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) obj[i], format);
                    }
                    // 문자 출력
                    String msg = "";
                    if(messages != null && messages.length > 0){
                        msg += messages[0].getOriginatingAddress()+"\n";
                        msg += messages[0].getMessageBody().toLowerCase()+"\n";
                        msg += new Date(messages[0].getTimestampMillis()).toString();
                        textView.setText(msg);
                    }
                }
            }
        };
        // 가동 : 신호가 오면 받겠다!
        registerReceiver(broadcastReceiver, intentFilter);

    } // end onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 해지 : 앱이 꺼지면 네트워크를 끊음. !! 반드시 처리 !!
        unregisterReceiver(broadcastReceiver);
    }

    public void ckbt(View v){
        if(v.getId() == R.id.button){
            int check = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if(check == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9090-9898"));
                startActivity(intent);
            }else{
                Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show();
            }

        }else if(v.getId() == R.id.button2){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(
                    "tel:010-2323-0433",
                    null,
                    "hi, Man ...",
                    null,
                    null
            );
            Toast.makeText(this, "Send ...OK", Toast.LENGTH_SHORT).show();
        }
    }
}