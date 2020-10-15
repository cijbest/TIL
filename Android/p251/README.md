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

- 첫 번째 화면

![캡쳐](https://user-images.githubusercontent.com/24764210/95992732-3f393200-0e69-11eb-98c7-9b3ae333b0fc.png) 

- 두 번째 화면

![캡처](https://user-images.githubusercontent.com/24764210/95993076-9d661500-0e69-11eb-91f1-fa5c5c2529b8.png) 

- 세 번째 화면
- 전화걸기 권한 허용창

![캡처](https://user-images.githubusercontent.com/24764210/96137688-e5536d80-0f37-11eb-80f4-b56b214633f3.png) 

![캡처](https://user-images.githubusercontent.com/24764210/96002031-a52ab700-0e73-11eb-93b2-4d4ba3e2c36f.png) 

< BUTTON1 실행 시 >

![캡처](https://user-images.githubusercontent.com/24764210/96002175-cd1a1a80-0e73-11eb-8d36-bcff6e4f1c5a.png) 

< BUTTON2 실행 시 >

![캡처](https://user-images.githubusercontent.com/24764210/96002420-0d799880-0e74-11eb-9d2f-689969beb36e.png) 

< BUTTON3 실행 시 >

- 전화 걸기 이벤트 실행

![캡처](https://user-images.githubusercontent.com/24764210/96138094-63b00f80-0f38-11eb-8e67-65dc3c253da4.png) 