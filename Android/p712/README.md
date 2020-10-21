# p712 실습

![제목 없음](https://user-images.githubusercontent.com/24764210/96688184-d3504f80-13bb-11eb-8185-cce8073cd374.png) 

- 푸시 메세지 전송
  - 브라우저(127.0.0.1/android/ftest)를 실행하면 웹서버(원하는 데이터 담은 코드 작성)에서 FCM에게 MessagingService를 요청한다. FCM는 해당 단말기에게 푸시 알람에 대한 메세지를 보낸다. 
  - 푸시알람을 보이게 하려면 안드로이드 프로젝트에서 Notification으로 처리를 해주어야 한다.
- FCM : Firebase Cloud Messaging, 구글의 푸시 서비스, 구글의 클라우드 서버를 사용해 메시지 전송 방식을 최적화한 서비스, 메세지를 받고자 하는 단말기를 이곳에 등록해야 서비스를 사용할 수 있다.
- console.firebase.google.com -> 프로젝트 추가 -> 프로젝트 설정 -> 앱 추가
- 클라우드 메세징 -> 서버 키 

- eclipse

  ```java
  package ftest;
  
  import java.io.IOException;
  import java.io.OutputStreamWriter;
  import java.net.HttpURLConnection;
  import java.net.MalformedURLException;
  import java.net.URL;
  
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  import org.json.simple.JSONObject;
  
  @WebServlet({ "/Ftest", "/ftest" })
  public class Ftest extends HttpServlet {
  	private static final long serialVersionUID = 1L;
  
      public Ftest() {
          super();
      }
  
  
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  			URL url = null;
  			try {
  				url = new URL("https://fcm.googleapis.com/fcm/send");
  			} catch (MalformedURLException e) {
  				System.out.println("Error while creating Firebase URL | MalformedURLException");
  				e.printStackTrace();
  			}
  			HttpURLConnection conn = null;
  			try {
  				conn = (HttpURLConnection) url.openConnection();
  			} catch (IOException e) {
  				System.out.println("Error while createing connection with Firebase URL | IOException");
  				e.printStackTrace();
  			}
  			conn.setUseCaches(false);
  			conn.setDoInput(true);
  			conn.setDoOutput(true);
  			conn.setRequestProperty("Content-Type", "application/json");
  
  			// set my firebase server key
  			conn.setRequestProperty("Authorization", "key="
  					+ "서버키");
  
  			// create notification message into JSON format
  			JSONObject message = new JSONObject();
  			message.put("to", "/topics/car");
  			message.put("priority", "high");
  			JSONObject notification = new JSONObject();
  			notification.put("title", "title1");
  			notification.put("body", "body1");
  			message.put("notification", notification);
  			
  			JSONObject data = new JSONObject();
  			data.put("control", "control1");
  			data.put("data", 100);
  			message.put("data", data);
  
  
  			try {
  				OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
  				out.write(message.toString());
  				out.flush();
  				conn.getInputStream();
  				System.out.println("OK...............");
  
  			} catch (IOException e) {
  				System.out.println("Error while writing outputstream to firebase sending to ManageApp | IOException");
  				e.printStackTrace();
  			}			
  	}
  }
  ```

  

