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
// Buffered Stream�� �� ������ ������ �о�´�.(��� Ȯ��)
	public static void main(String[] args) throws IOException {
		String file = "test.txt";
		FileReader fis = null;
		BufferedReader bis = null;
		FileWriter fos = null;
		BufferedWriter bos = null;
		try {
			fis = new FileReader(file);
			bis = new BufferedReader(fis); // �⺻ 5����Ʈ
			// �о���� �����͸� test2.txt�� �ְڴ�.
			fos = new FileWriter("test2.txt");
			bos = new BufferedWriter(fos);
			
			String data = "";
			// readLine : �� ���ξ� �о����, buffered���� ����
			while((data = bis.readLine()) != null) { 
				bos.write(data);
				System.out.println(data);
				//fos.write(data);
			}
			//System.out.println(fis.available());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			// �ݵ�� close ���� ��!!
			// bis, bos�� close���൵ fis, fos�� �ڵ����� close �ȴ�.
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
