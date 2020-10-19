package com.example.r500;


import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    ListView listView;
    LinearLayout container;
    ArrayList<Item> list; // item 정보 담을 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = findViewById(R.id.listView);
        container = findViewById(R.id.container);
        list = new ArrayList<>();
        getData();
    }

    private void getData() {
        String url = "http://172.30.1.27/android/items.jsp";
        ItemAsync itemAsync = new ItemAsync();
        itemAsync.execute(url);
    }


    class ItemAsync extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(SecondActivity.this);
            progressDialog.setTitle("Get Data ...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0].toString();
            String result = HttpConnect.getString(url);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            // 파싱해서 item값을 추출하고 list에 삽입
            JSONArray ja = null;
            try {
                ja = new JSONArray(s);
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = ja.getJSONObject(i);
                    String name = jo.getString("name");
                    String id = jo.getString("id");
                    int age = jo.getInt("age");
                    String img = jo.getString("img");
                    int grade = jo.getInt("grade");
                    Item item = new Item(id, name, age, img, grade);
                    list.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ItemAdapter itemAdapter = new ItemAdapter();
            // listView에 item을 리스트로 뿌려줌
            listView.setAdapter(itemAdapter);
        }
    } // end AsyncTask

    class ItemAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override

        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = null;
            LayoutInflater inflater =
                    (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // item.xml 을 가져옴
            itemView = inflater.inflate(R.layout.activity_item, container, true);
            TextView tx_id = itemView.findViewById(R.id.textView);
            TextView tx_name = itemView.findViewById(R.id.textView2);
            TextView tx_age = itemView.findViewById(R.id.textView3);
            tx_id.setText(list.get(position).getId());
            tx_name.setText(list.get(position).getName());
            tx_age.setText(list.get(position).getAge() + "");

            // 서버에서 이미지 가져와서 리스트 안의 ImageView에 띄우기
            final ImageView imageView = itemView.findViewById(R.id.imageView);

            String img = list.get(position).getImg();
            final String url = "http://172.30.1.27/android/img/";

            // GetImg 스레드를 통해 이미지 가져오기
            GetImg t1 = new GetImg(img, url, imageView);
            t1.start();

            final ImageView imageView2 = itemView.findViewById(R.id.imageView2);
            int grade = list.get(position).getGrade();

            // grade 점수에 따른 등급 이미지 결정
            String rimg = null;
            if(grade == 1){
                rimg = "gold.jpg";
            }else if(grade == 2){
                rimg = "silver.jpg";
            }else{
                rimg = "bronze.jpg";
            }

            GetImg t2 = new GetImg(rimg, url, imageView2);
            t2.start();

            // 하나의 스레드를 사용할 때
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    URL httpurl = null;
                    InputStream is = null;

                    try {
                        httpurl = new URL(url);
                        is = httpurl.openStream();
                        final Bitmap bm = BitmapFactory.decodeStream(is);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bm);
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            return itemView;
        }

        // 여러 개의 스레드를 사용할 때 클래스화
        class GetImg extends Thread{
            String img;
            String url;
            ImageView imageview;
            public GetImg(String img, String url, ImageView imageView){
                this.img = img;
                this.url = url;
                this.imageview = imageView;
            }

            @Override
            public void run() {
                URL httpurl = null;
                InputStream is = null;

                try {
                    // url 생성
                    httpurl = new URL(url+img);
                    // url의 stream 개방
                    is = httpurl.openStream();
                    // bitmap 이미지로 해당 이미지 받아옴. 적절한 사이즈로 받아옴
                    final Bitmap bm = BitmapFactory.decodeStream(is);

                    // UI는 메인 스레드에서만 바꿀 수 있으므로 runOnUiThread를 사용
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageview.setImageBitmap(bm);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    } // end Adapter
}
