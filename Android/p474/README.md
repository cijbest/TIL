# p474 실습

- 자바에서만 구현 가능
  - Thread & Runnable

- 안드로이드에서만 구현 가능(안드로이드는 세 가지 다 사용)
  - Handler : 서브 스레드 안에서 동작되어지는 변경된 상태를 메인 스레드에게 알려주는 역할
  - AsynchTask

- 예시) 스레드를 하나 만들면 그곳에서 for문이 돌아감

- 서브 스레드는 메인 스레드에 있는 내용들을 변경할 수 없음 

  - runOnUiThread 사용하면 가능

  ```java
  runOnUiThread(new Runnable() {
      @Override
      public void run() {
          //button.setEnabled(true);
      }
  });
  ```

## 실행화면

![캡처](https://user-images.githubusercontent.com/24764210/96211524-80d3f500-0faf-11eb-985e-82bfde418f43.png) 

![캡처](https://user-images.githubusercontent.com/24764210/96211578-b082fd00-0faf-11eb-93f6-1472e1bcc4ce.png) 

- 5초 위에 Prograss 종료

![캡처](https://user-images.githubusercontent.com/24764210/96211680-ef18b780-0faf-11eb-82a4-8ed6d83ba130.png)  ![캡처](https://user-images.githubusercontent.com/24764210/96211722-0a83c280-0fb0-11eb-9396-2a543b50c181.png) 