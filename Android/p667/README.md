# p667 실습

- getSystemsService() : 위치 관리자 객체를 참조
- LocationListener : 전달 받은 위치 정보를 처리
  - Listener(리스너) : 어떠한 정보를 받을 때 언제 받을지 모르니 기다리고 있는 상태(=대기 상태)를 말한다.
- requestLocationUpdates() : 위치 정보가 변경될 때마다 바뀐 정보(리스너 객체)를 전달

- GPS를 사용할 수 있도록 AndroidManifest.xml에 권한 추가

  ```xml
  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
  ```

- GPS로 현재 위치 정보(위도, 경도) 실시간으로 받기

## 실행화면

![제목 없음](https://user-images.githubusercontent.com/24764210/96541900-f1df1980-12db-11eb-8e30-281fb1aada47.png) 

- ALLOW하고 앱 실행

![제목 없음](https://user-images.githubusercontent.com/24764210/96541991-1b984080-12dc-11eb-9a41-841cbcaf2c65.png) 