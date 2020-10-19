# p533 실습

- 영화 상영 정보 Open API의 JSON 데이터를 가공하여 영화 정보를 리스트  형태로 출력

- eclipse : android/web/login.jsp

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

## 실행화면

![캡처](https://user-images.githubusercontent.com/24764210/96461829-d2a2a680-125f-11eb-8545-05b79b457760.png) 

![캡처](https://user-images.githubusercontent.com/24764210/96461911-ecdc8480-125f-11eb-8020-4a58aaab5e6e.png) 

![캡처](https://user-images.githubusercontent.com/24764210/96462013-08e02600-1260-11eb-8892-32273534df98.png) 



