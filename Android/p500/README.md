# p500 실습

- login.jsp 생성

  - id, pwd 값이 같으면 "1"을 리턴

  ```jsp
  <%@ page language="java" contentType="text/html; charset=EUC-KR"
      pageEncoding="EUC-KR"%>
  <%
  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");
  Thread.sleep(3000); // 3초 후에 아이디, 비밀번호 확인
  if(id.equals("id01") && pwd.equals("pwd01")){
  	out.print("1");
  } else{
  	out.print("2");
  }
  %>
  ```

- 앱에서 로그인 버튼 클릭 시 id, pwd 값을 서버로 보내기

  - 안드로이드 정책 : 서버에 연결할 땐 무조건 스레드로 보낼 것 .
  
- 로그인 중일 때, PrograssDialog 띄우기

- 로그인 성공 시, SecondActivity로 이동

- 로그인 실패 시, AlertDialog 띄우기

- permission 추가

   ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <manifest xmlns:android="http://schemas.android.com/apk/res/android"
      package="com.example.r500">
  	
      <!-- 추가 -->
      <uses-permission android:name="android.permission.INTERNET" />
  
      <!-- 마지막 줄 추가 -->
      <application
          ~~~ 
          android:usesCleartextTraffic="true">
   ```

## 실행화면

- 메인

![메인](https://user-images.githubusercontent.com/24764210/96227197-be944600-0fce-11eb-9dac-205c71686834.jpg) 

- 로딩

![로딩](https://user-images.githubusercontent.com/24764210/96227223-cbb13500-0fce-11eb-999a-ecc2edd848c3.jpg) 

- 로그인 성공 화면

![로그인성공](https://user-images.githubusercontent.com/24764210/96227263-dbc91480-0fce-11eb-9236-1a7e08c16a96.jpg) 

- 로그인 실패 화면

![로그인실패](https://user-images.githubusercontent.com/24764210/96227295-e4214f80-0fce-11eb-811f-a023e88a3b3b.jpg) 