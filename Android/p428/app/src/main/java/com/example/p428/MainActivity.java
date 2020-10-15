package com.example.p428;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Person> persons;
    ConstraintLayout container;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        container = findViewById(R.id.container);
    }

    class PersonAdapter extends BaseAdapter{

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
            ImageView im = view.findViewById(R.id.imageView);
            TextView tx_id = view.findViewById(R.id.tx_id);
            TextView tx_name = view.findViewById(R.id.tx_name);
            TextView tx_age = view.findViewById(R.id.tx_age);
            Person p = datas.get(position);
            im.setImageResource(p.getImg());
            tx_id.setText(p.getId());
            tx_name.setText(p.getName());
            tx_age.setText(""+p.getAge());
            return view;
        }
    }
    public void setList(final ArrayList<Person> persons){
        PersonAdapter personAdapter = new PersonAdapter(persons);
        listView.setAdapter(personAdapter);

        // list 클릭 이벤트 생성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                // Alert 창 띄우기
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // Alert 창에 클릭한 사진 띄우기
                LayoutInflater layoutInflater = getLayoutInflater();
                View dview = layoutInflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.dlayout));
                ImageView dimg = dview.findViewById(R.id.imageView2);
                dimg.setImageResource(persons.get(position).getImg());
                builder.setView(dview);

                // Alert 창에 이름 표시
                builder.setMessage(persons.get(position).getName()); // 리스트 아이템 이름 출력

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void getData(){
        persons = new ArrayList<>();
        persons.add(new Person(R.drawable.p1, "0001", "Lee Malsook", 29));
        persons.add(new Person(R.drawable.p2, "0002","Kim Malsook", 28));
        persons.add(new Person(R.drawable.p3, "0003","Choi Malsook", 27));
        persons.add(new Person(R.drawable.p4, "0004","Seo Malsook", 26));
        persons.add(new Person(R.drawable.p5, "0005","Yang Malsook", 25));
        persons.add(new Person(R.drawable.p6, "0006","Han Malsook", 24));
        persons.add(new Person(R.drawable.p7, "0007","Min Malsook", 23));
        persons.add(new Person(R.drawable.p8, "0008","Hong Malsook", 22));
        persons.add(new Person(R.drawable.p9, "0009","Park Malsook", 21));
        persons.add(new Person(R.drawable.p10, "0010","Jang Malsook", 20));
        setList(persons);
    }

    public void ckbt(View v){
        getData();
    }
}