package com.example.p426;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

    }

    // 데이터 뿌리기
    public void setList(final ArrayList<String> datas){
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
        // list 클릭 이벤트 생성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                // Alert 창 띄우기
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hi!");
                builder.setMessage("Are you deleted this Item : " + datas.get(position)); // 리스트 아이템 이름 출력

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datas.remove(position);
                        // 삭제한 후 데이터 업데이트
                        adapter.notifyDataSetChanged();
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

    // 데이터 가져오기
    public void getData(){
        datas = new ArrayList<>();
        // 가상의 데이터 생성
        for(int i = 1; i <= 20; i++){
            datas.add("Item:"+i);
        }
        setList(datas);
    }

    public void ckbt(View v){
        getData();
    }
}