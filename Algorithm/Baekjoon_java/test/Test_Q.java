package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test_Q {

	public static void main(String[] args) {
		ArrayList<Queue> list = new ArrayList<>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		list.add(q1);
		list.add(q2);
		list.add(q3);
		
		list.get(0).add(111);
		list.get(0).add(99);
		System.out.println(list.get(0));
	}

}
