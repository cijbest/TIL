package queue;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q_Test {

	public static void main(String[] args) {
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list.remove(2)); // ÀÎµ¦½º ¿ì¼±
//
//
//		LinkedList<String> list2 = new LinkedList<String>();
//		list2.add("app");
//		System.out.println(list2.remove("app"));
//		System.out.println(list2);
		
//		char[] c = {'q', '1', '6', 'f'};
		String s = "[1,2,3,4]";
		StringTokenizer st = new StringTokenizer(s,"[],");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
