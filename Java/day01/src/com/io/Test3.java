package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test3 {

	public static void main(String[] args) throws Exception {
		User user = new User("id01", "ÀÌ¸»¼÷");
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("user.serial");
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(user);
			System.out.println("Write Complete ...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			}
		}
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("user.serial");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			User readUser = null;
			readUser = (User) ois.readObject();
			System.out.println(readUser);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				ois.close();
			}
		}
	}

}
