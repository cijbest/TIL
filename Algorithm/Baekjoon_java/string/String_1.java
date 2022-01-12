package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class String_1 {

	public static void main(String[] args) throws IOException {
		/*
		InputStream inputstream = System.in;
		InputStreamReader sr = new InputStreamReader(inputstream);
		int c = sr.read();
		System.out.println((char)c);
		*/	
		
		// BufferedReader : 입력을 많이 받아야 할 때, 속도 향상
		// 10 20 30 40 => 4060
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		String a = line[0] + line[1];
		String b = line[2] + line[3];
		long result = Long.valueOf(a) + Long.valueOf(b);
		System.out.println(result);
		

	}

}
