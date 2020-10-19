# p500 실습 응용

- 서버에 있는 JSON데이터와 이미지 데이터에 접근해서 정보를 출력

  - 인물 데이터 옆에 등급에 따른 gold, silver, bronze 구분하여 이미지 출력

  - HttpConnect : 서버와 연결

    - HttpConnect.getString(url) : 해당 url로부터 리턴된 string 값을 받음

  - 스레드를 이용하여 서버로부터 이미지를 가져옴

    - 하나의 스레드를 사용할 때

      ```java
      Thread t = new Thread(new Runnable() {
                      @Override
                      public void run() {
                          URL httpurl = null;
                          InputStream is = null;
      
                          try {
                              httpurl = new URL(url);
                              is = httpurl.openStream();
                              final Bitmap bm = BitmapFactory.decodeStream(is);
      
                              runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      imageView.setImageBitmap(bm);
                                  }
                              });
      
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                      }
                  });
                  t.start();
      ```

    - 여러 개의 동일한 스레드를 사용할 때, 클래스를 생성하여 사용

      ```java
      class GetImg extends Thread{
                  String img;
                  String url;
                  ImageView imageview;
                  public GetImg(String img, String url, ImageView imageView){
                      this.img = img;
                      this.url = url;
                      this.imageview = imageView;
                  }
      
                  @Override
                  public void run() {
                      URL httpurl = null;
                      InputStream is = null;
      
                      try {
                          // url 생성
                          httpurl = new URL(url+img);
                          // url의 stream 개방
                          is = httpurl.openStream();
                          // bitmap 이미지로 해당 이미지 받아옴. 적절한 사이즈로 받아옴
                          final Bitmap bm = BitmapFactory.decodeStream(is);
      
                          // UI는 메인 스레드에서만 바꿀 수 있으므로 runOnUiThread를 사용
                          runOnUiThread(new Runnable() {
                              @Override
                              public void run() {
                                  imageview.setImageBitmap(bm);
                              }
                          });
      
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              }
      ```

      

- android/web/item.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=EUC-KR"
      pageEncoding="EUC-KR"%>
  <%
  Thread.sleep(2000);
  %>
  [
  {"id":"id01", "name":"James1", "age":10, "img":"img01.jpg", "grade":1},
  {"id":"id02", "name":"James2", "age":20, "img":"img02.jpg", "grade":2},
  {"id":"id03", "name":"James3", "age":30, "img":"img03.jpg", "grade":3},
  {"id":"id04", "name":"James4", "age":40, "img":"img04.jpg", "grade":2},
  {"id":"id05", "name":"James5", "age":50, "img":"img05.jpg", "grade":1},
  {"id":"id06", "name":"James6", "age":60, "img":"img06.jpg", "grade":2},
  {"id":"id07", "name":"James7", "age":70, "img":"img07.jpg", "grade":1},
  {"id":"id08", "name":"James8", "age":80, "img":"img08.jpg", "grade":1},
  {"id":"id09", "name":"James9", "age":90, "img":"img09.jpg", "grade":3},
  {"id":"id10", "name":"James10", "age":100, "img":"img10.jpg", "grade":2}
  ]
  ```

- android/web/img

  ![캡처](https://user-images.githubusercontent.com/24764210/96465688-33cc7900-1264-11eb-9ea6-e935beb64ba8.png) 

## 실행화면

![캡처](https://user-images.githubusercontent.com/24764210/96465296-c28cc600-1263-11eb-831a-2af292d33cbe.png) 