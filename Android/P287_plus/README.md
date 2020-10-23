# p278 응용실습

- Fragment에서 지도 뿌릴 때 MapView를 이용한다.

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

- 구글 맵 띄우기
  - https://console.developers.google.com
  - 사용자 인증 정보 -> API 키 발급
  - cmd 창 켜고 `cd {program files -> java -> jdk -> bin경로}`로 이동 SHA-1 복사
  - 안드로이드 앱 추가 -> 프로젝트명이랑 SHA-1 추가하고 저장
  - AndroidManifest.xml 에 API 키 붙여넣기 