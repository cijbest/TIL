package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Server
 * login.jsp, id�� pwd�� �޾Ƽ� qqq, 111�̸� 1�� ���� �׷��� ������ 0�� ����
 * 
 * client
 * id���� pwd���� ������ ������ �� ����� �޾Ƽ� ����Ѵ�.
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
			con.setReadTimeout(3000); //5�� �Ŀ� ������ ���� ������ ����
			con.setRequestMethod("POST");

			is = con.getInputStream();
			isr = new InputStreamReader(is, "UTF-8"); // �ѱ� ���ڵ� ����
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
