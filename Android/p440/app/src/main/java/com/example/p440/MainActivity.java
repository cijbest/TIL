package com.example.p440;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Person> persons;
    LinearLayout container;
    EditText et_name;
    TextView birth;
    EditText et_phone;
    TextView count;


    ActionBar actionBar;

    BroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        container = findViewById(R.id.container);

        et_name = findViewById(R.id.et_name);
        birth = findViewById(R.id.birth);
        et_phone = findViewById(R.id.et_phone);

        actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.notwifi);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);

        count = findViewById(R.id.count);




        // 등록
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); // 네트워크가 변경되었다는 정보

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
                    wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    if(wifi != null && wifi.isConnected()){ // 인터넷 연결 됐을 때
                        actionBar.setLogo(R.drawable.wifi);
                    }else { // 연결이 끊겼을 때
                        actionBar.setLogo(R.drawable.notwifi);
                    }
                }
            }
        };
        // 가동 : 신호가 오면 받겠다!
        registerReceiver(broadcastReceiver, intentFilter);

        getData();
    }

    class PersonAdapter extends BaseAdapter {

        ArrayList<Person> datas;
        public PersonAdapter(ArrayList<Person> datas){
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override // 화면 리턴
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // view는 한 셀을 의미
            // person.xml UI를  listView에 붙이겠다.
            view = inflater.inflate(
                    R.layout.person,
                    container,
                    true
            );

            TextView tx_name = view.findViewById(R.id.tx_name);
            TextView tx_birth = view.findViewById(R.id.tx_birth);
            TextView tx_phone = view.findViewById(R.id.tx_phone);
            Person p = datas.get(position);
            tx_name.setText(p.getName());
            tx_birth.setText(p.getBirth());
            tx_phone.setText(p.getPhone());

            return view;
        }
    }
    public void setList(final ArrayList<Person> persons){
        final PersonAdapter personAdapter = new PersonAdapter(persons);
        listView.setAdapter(personAdapter);
        count.setText(personAdapter.getCount()+"명");

        // 달력 이벤트 생성
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View dview = layoutInflater.inflate(R.layout.cal, (ViewGroup) findViewById(R.id.dlayout) );
                final CalendarView calendarView = dview.findViewById(R.id.calendarView);
                builder.setView(dview);
                builder.setTitle("Hi");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                long d = calendarView.getDate();
                                SimpleDateFormat timeStampFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.KOREA);
                                String date = timeStampFormat.format(new Timestamp(d));
                                birth.setText(date);
                            }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });


        // 추가 이벤트 생성
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person(et_name.getText().toString(), birth.getText().toString(), et_phone.getText().toString());
                persons.add(p);
                et_name.setText("");
                birth.setText("");
                et_phone.setText("");
                personAdapter.notifyDataSetChanged();
                count.setText(personAdapter.getCount()+"명");
            }
        });


        // list 클릭 이벤트 생성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // Alert 창 띄우기
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Alert 창에 이름 표시
                builder.setMessage(persons.get(position).getName()+"님을 삭제하시겠습니까 ..?"); // 리스트 아이템 이름 출력

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        persons.remove(position);
                        // 삭제한 후 데이터 업데이트
                        personAdapter.notifyDataSetChanged();
                        count.setText(personAdapter.getCount()+"명");
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
        });

    }

    public void getData(){
        persons = new ArrayList<>();
        persons.add(new Person("고객1", "1997-07-07", "010-777-7777"));
        persons.add(new Person("고객2", "1997-07-08", "010-777-7777"));
        persons.add(new Person("고객3", "1997-07-09", "010-777-7777"));
        setList(persons);
    }


}