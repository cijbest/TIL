# p251 실습

- 메인 액티비티에서 세컨 액티비티로 이동하는 이벤트

- 메인 액티비티에 세컨 액티비티가 위로 올라오는 것

- 세컨 액티비티에 값을 전달

- Second Activity, Third Activity 생성

  - new -> Activity -> Empty Activity

- 전화 걸기 이벤트 실행 시, permission 에러가 남

  - AndroidManifest.xml에 코드 추가

    ```xml
     <uses-permission android:name="android.permission.CALL_PHONE"/> 
    ```

## 실행화면

![캡쳐](https://user-images.githubusercontent.com/24764210/95992732-3f393200-0e69-11eb-98c7-9b3ae333b0fc.png) 

![캡처](https://user-images.githubusercontent.com/24764210/95993076-9d661500-0e69-11eb-91f1-fa5c5c2529b8.png) 