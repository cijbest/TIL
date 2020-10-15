# p362 실습 

1. permission 체크를 통해서 버튼을 눌렀을 때 전화걸기와 문자전송이 가능하게 하는 이벤트(사용자에게 접근 권한에 대한 허가를 구함)

- 보안설정

  - AndroidManifest.xml

    ```xml
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.RECEIVE_SMS"/>
    <uses-permission android:name="android.permission.SEND_SMS"/>
    <uses-permission android:name="android.permission.CALL_PHONE"/>
    ```

- intent : 앱과 앱 사이에 정보 전송을 도움

2. wifi가 연결됐을 때와 연결되지 않았을 때 이미지를 다르게 표시

3. 문자를 받았을 때 받은 내용 출력

## 실행화면

< 1 >

![캡처](https://user-images.githubusercontent.com/24764210/96067585-1189d280-0ed5-11eb-9db6-13cfd6a638d1.PNG) 

![캡처](https://user-images.githubusercontent.com/24764210/96067710-54e44100-0ed5-11eb-97c4-781f63371d85.PNG) 

- button1

![캡처](https://user-images.githubusercontent.com/24764210/96067873-a42a7180-0ed5-11eb-9f47-a6579a00bb19.PNG) 

- button2

![캡처](https://user-images.githubusercontent.com/24764210/96067983-d8059700-0ed5-11eb-921a-abb6052a9720.PNG) 

< 2 >

![캡처](https://user-images.githubusercontent.com/24764210/96067770-70e7e280-0ed5-11eb-8b0d-73633311157b.PNG) 

![캡처](https://user-images.githubusercontent.com/24764210/96067833-8bba5700-0ed5-11eb-886c-b820e6bb05f4.PNG) 

< 3 >

![캡처](https://user-images.githubusercontent.com/24764210/96068028-f4093880-0ed5-11eb-9e4c-62bb4e0e01fc.PNG) 