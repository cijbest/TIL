package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Server
 * login.jsp, id와 pwd를 받아서 qqq, 111이면 1을 전송 그렇지 않으면 0을 전송
 * 
 * client
 * id값과 pwd값을 서버로 전송한 후 결과를 받아서 출력한다.
 */

public class Test4 {

	public static void main(String[] args) {

String urlstr = "http://192.168.0.7/network/login.jsp";
		
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			String id = "qqq";
			String pwd = "111";
			url = new URL(urlstr+"?id="+id+"&pwd="+pwd);
			con = (HttpURLConnection) url.openConnection();
			con.setReadTimeout(3000); //5초 후에 서버의 응답 없으면 종료
			con.setRequestMethod("POST");

			is = con.getInputStream();
			isr = new InputStreamReader(is, "UTF-8"); // 한글 인코딩 지정
			br = new BufferedReader(isr);
			
			String str = "";

			while((str = br.readLine()) != null) {
				if(!str.equals("")) {
					System.out.println(str.trim());
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
