package com.example.ws;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Fragment1 extends Fragment {

    ListView listView;
    LinearLayout container;
    ArrayList<Movie> list;

    public Fragment1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Main에서는 activity를 상속 받기 때문에 바로 findViewById를 사용할 수 있지만 fragment는 ViewGroup으로 가지고 와서 사용해야 함
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup) inflater.inflate(
                R.layout.fragment_1, container, false
        );

        listView = viewGroup.findViewById(R.id.listView);
        container = viewGroup.findViewById(R.id.container);
        list = new ArrayList<>();
        getData();

        return viewGroup;
    }

    private void getData() {
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200101";
        ItemAsync itemAsync = new ItemAsync();
        itemAsync.execute(url);
    }


    class ItemAsync extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("잠시만 기다려주세요");
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
            JSONObject joa = null;
            JSONArray ja = null;

            try {
                joa = new JSONObject(s);
                joa = joa.getJSONObject("boxOfficeResult");
                ja = joa.getJSONArray("dailyBoxOfficeList");
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = ja.getJSONObject(i);
                    String movieCd = jo.getString("movieCd");
                    String rank = jo.getString("rank");
                    String movieNm = jo.getString("movieNm");
                    String openDt = jo.getString("openDt");
                    String salesAcc = jo.getString("salesAcc");
                    String audiAcc = jo.getString("audiAcc");
                    String img = movieCd + ".jpg";

                    Movie movie = new Movie(movieCd, rank, movieNm, img, openDt, salesAcc, audiAcc);
                    list.add(movie);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ItemAdapter itemAdapter = new ItemAdapter();
            listView.setAdapter(itemAdapter);


            // AlertDialog 띄우기기
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


                    builder.setTitle(list.get(position). getMovieNm());

                    // Alert 창에 이름 표시
                    builder.setMessage("# " + list.get(position).getMovieCd()+"\n"+
                            "NO." + list.get(position).getRank() + "\n" +
                            list.get(position).getOpenDt() + " 개봉\n" +
                            "현재 누적관객수 " + list.get(position).getAudiAcc() + "명\n" +
                            "현재 누적매출액 " + list.get(position).getSalesAcc() + "원"); // 리스트 아이템 이름 출력

                    // 이미지 삽입(스레드 사용 : 서버에 있는 사진 받아옴)
                    final String url = "http://172.30.1.27/android/img/";
                    LayoutInflater layoutInflater = getLayoutInflater();

                    View dview = layoutInflater.inflate(R.layout.imglayout, (ViewGroup) getActivity().findViewById(R.id.imglayout));
                    ImageView dimg = dview.findViewById(R.id.imageView2);

                    GetImg t3 = new GetImg(list.get(position).getImg(), url, dimg);
                    t3.start();

                    builder.setView(dview);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });

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
                    (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.movie, container, true);
            TextView movieCd = itemView.findViewById(R.id.tx);
            TextView rank = itemView.findViewById(R.id.textView2);
            TextView movieNm = itemView.findViewById(R.id.textView3);

            // 영화 정보 출력
            movieCd.setText("NO. " + list.get(position).getRank());
            rank.setText(list.get(position).getMovieNm());
            movieNm.setText(list.get(position).getOpenDt()  + " 개봉");

            // 영화 포스터 이미지 설정
            final ImageView imageView = itemView.findViewById(R.id.imageView);
            String img = list.get(position).getImg();
            final String url = "http://172.30.1.27/android/img/";
            GetImg t1 = new GetImg(img, url, imageView);
            t1.start();

            // rank 이미지 설정
            ImageView imageView2 = itemView.findViewById(R.id.imageView3);
            String rankimg = "";
            if (list.get(position).getRank().equals("1")){
                rankimg = "gold.png";
            }else if(list.get(position).getRank().equals("2")){
                rankimg = "silver.png";
            }else if(list.get(position).getRank().equals("3")){
                rankimg = "bronze.png";
            }

            GetImg r1 = new GetImg(rankimg, url, imageView2);
            r1.start();

            return itemView;
        }



    } // end Adapter
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
                httpurl = new URL(url+img);
                is = httpurl.openStream();
                final Bitmap bm = BitmapFactory.decodeStream(is);

                getActivity().runOnUiThread(new Runnable() {
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


}