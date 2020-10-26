package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
// Buffered Stream이 더 빠르게 파일을 읽어온다.(기능 확장)
	public static void main(String[] args) throws IOException {
		String file = "test.txt";
		FileReader fis = null;
		BufferedReader bis = null;
		FileWriter fos = null;
		BufferedWriter bos = null;
		try {
			fis = new FileReader(file);
			bis = new BufferedReader(fis); // 기본 5바이트
			// 읽어들인 데이터를 test2.txt에 넣겠다.
			fos = new FileWriter("test2.txt");
			bos = new BufferedWriter(fos);
			
			String data = "";
			// readLine : 한 라인씩 읽어들임, buffered에만 있음
			while((data = bis.readLine()) != null) { 
				bos.write(data);
				System.out.println(data);
				//fos.write(data);
			}
			//System.out.println(fis.available());
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
