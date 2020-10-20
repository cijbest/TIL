# p675 실습

1. empty activity 생성

2. google 사이트에 패키지 정보 입력

3. build.gradle(:app)에 googleMap 관련 API 추가 후 sync now

   ```xml
   implementation 'com.google.android.gms:play-services-maps:17.0.0'
   ```

4. androidmanifest.xml 에 key 값 입력

   ```xml
   <meta-data
               android:name="com.google.android.geo.API_KEY"
               android:value="키값" />
   ```

5. 화면에 Fragment 추가

   - Fragment는 UI로 바로 추가할 수 없으므로 code에 Fragment 추가가 먼저

     ```xml
     <fragment
             android:id="@+id/map"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             android:name="com.google.android.gms.maps.SupportMapFragment"/>
     ```

6.  google 지도 화면에 띄우기

   - 위도, 경도에 따른 지역 띄우기
   - 마커 표시
   - 마커 대신 그림 띄우기

## 소스코드

**키 값이 포함되어 있어 MainActivity의 소스만 게시**

```java
package com.example.p675;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    SupportMapFragment supportMapFrgment;
    GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportMapFrgment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFrgment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                // 원하는 위치의 경도와 위도를 지정
                LatLng latlng = new LatLng(37.5947264,127.0005577);
                // 해당 위치에 마커와 제목을 붙임
                gmap.addMarker(
                        new MarkerOptions().position(latlng).title("공항")
                );
                // zoom 사이즈 설정
                gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10));
            }
        });
    }

    public void ck1(View v){
        LatLng latlng = new LatLng(48.590735,98.9725753);
        // 해당 위치에 마커와 제목을 붙임
        gmap.addMarker(
                new MarkerOptions().position(latlng).title("몽골")
        );
        // zoom 사이즈 설정
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10));
    }

    public void ck2(View v){
        LatLng latlng = new LatLng(21.491977, -158.156517);
        // 해당 위치에 마커와 제목을 붙임
        gmap.addMarker(
                new MarkerOptions().position(latlng).title("하와이").snippet("xxx").icon(BitmapDescriptorFactory.fromResource(R.drawable.ice))
        );
        // zoom 사이즈 설정
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10));
    }
}
```

## 실행화면

![제목 없음](https://user-images.githubusercontent.com/24764210/96547171-98301c80-12e6-11eb-986b-c4d1867ed9ee.png) 

![제목 없음](https://user-images.githubusercontent.com/24764210/96547231-b72eae80-12e6-11eb-9de4-75085c5dcfb3.png) 

![제목 없음](https://user-images.githubusercontent.com/24764210/96547297-d2012300-12e6-11eb-9021-d90101a5ccf5.png) 