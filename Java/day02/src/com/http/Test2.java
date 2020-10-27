package com.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

//서버에 있는 데이터(파일-mp3) 가져오기
public class Test2 {

	public static void main(String[] args) {

		String urlstr = "http://192.168.0.7/network/mp.mp3";
		URL url = null;
		URLConnection con = null;
		
		InputStream is = null;
		BufferedInputStream bis = null;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		
		try {
			url = new URL(urlstr);
			con = url.openConnection();
			is = con.getInputStream();
			bis = new BufferedInputStream(is, 10000000);
			
			fos = new FileOutputStream("newmp.mp3");
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			while((data = bis.read()) != -1) {
				System.out.println(data);
				bos.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
