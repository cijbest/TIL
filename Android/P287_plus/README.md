# p278 응용실습

- Fragment에서 지도 뿌릴 때 SecondActivity를 만들어서 지도를 뿌려야 함

  - fragment_3.xml

    ```xml
    <com.google.android.gms.maps.MapView
              android:id="@+id/map"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:name="com.google.android.gms.maps.SupportMapFragment"
              />
    ```
  
- AndroidManifest.xml

  - ACCESS_FINE_LOCATION : 경도, 위도 가져옴
  - ACCESS_COARSE_LOCATION : 내 위치 가져옴

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
```

