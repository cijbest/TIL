package com.http;

import java.net.HttpURLConnection;
import java.net.URL;


// 서버로 데이터 전송
public class Test3 {

	public static void main(String[] args) {
		String urlstr = "http://192.168.0.7/network/car.jsp";
		
		URL url = null;
		HttpURLConnection con = null;
		
		while(true) {
			try {
				double lat = Math.random()*90 + 1;
				double lng = Math.random()*90 + 1;
				url = new URL(urlstr+"?lat="+lat+"&lng="+lng);
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(3000); //5초 후에 서버의 응답 없으면 종료
				con.setRequestMethod("POST");
				con.getInputStream();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.disconnect();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		

	}

}
