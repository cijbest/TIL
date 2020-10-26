package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
// Buffered Stream�� �� ������ ������ �о�´�.(��� Ȯ��)
	public static void main(String[] args) throws IOException {
		String file = "test.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // �⺻ 5����Ʈ
			// �о���� �����͸� test2.txt�� �ְڴ�.
			fos = new FileOutputStream("test2.txt");
			bos = new BufferedOutputStream(fos);
			
			int data = 0;
			// ����Ʈ ������ �о��
			while((data = fis.read()) != -1) {
				bos.write(data);
				//fos.write(data);
			}
			System.out.println(fis.available());
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
