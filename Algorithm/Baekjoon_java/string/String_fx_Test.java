package string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class String_fx_Test {

	public static void main(String[] args) {
		String str = "ABCDEF";
		System.out.println(str.replaceFirst("D", "super"));
		
		char[] cArr = str.toCharArray();
		System.out.println(cArr);
		System.out.println(Arrays.copyOfRange(cArr, 2, 5));
		
		System.out.println("----------------------");
		String str2 = "VSDTEWSDGE";
		char[] c2 = str2.toCharArray();
		Arrays.sort(c2);

		ArrayList<Queue> qArr = new ArrayList<Queue>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		qArr.add(q1);
		qArr.add(q2);
		qArr.add(q3);
		q1.offer(1);
		q2.offer(2);
		q3.offer(3);
		q2.poll();
		System.out.println(qArr);
		System.out.println("----------------------");
		
		char s = '3';
		System.out.println(Character.isDigit(s));
		
		String ss = "123353465768234";
		System.out.println(ss.chars().filter(c -> c == s).count());
		
	}

}
