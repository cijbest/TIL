package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
// Buffered Stream이 더 빠르게 파일을 읽어온다.(기능 확장)
	public static void main(String[] args) throws IOException {
		String file = "test.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // 기본 5바이트
			// 읽어들인 데이터를 test2.txt에 넣겠다.
			fos = new FileOutputStream("test2.txt");
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			// 바이트 단위로 읽어옴
			while((data = fis.read()) != -1) {
				bos.write(data);
				//fos.write(data);
			}
			System.out.println(fis.available());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			// 반드시 close 해줄 것!!
			// bis, bos만 close해줘도 fis, fos는 자동으로 close 된다.
			if(bis != null) { 
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
