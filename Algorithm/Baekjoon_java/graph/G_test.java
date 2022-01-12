package graph;

import java.util.*;

public class G_test {
	static void method1(int[] arr2)
	{
	    // arr2 배열은 main 의 arr 배열과 같은 주소를 가리키고 있으므로 값을 바꾸면 arr 배열의 값도 바뀜
	    arr2[0] = 20; 
	}
	
	static class People implements Comparable {

	    private String name;
	    private int age;
	    
	    public People(String name, int age){
	        this.name = name;
	        this.age= age;
	    }

	    public String print(){
	        return name+"("+age+")";
	    }

		@Override
		public int compareTo(Object o) {
			return ((People)o).age - this.age;
	        
		}

	    
	}
	static public class Sky{
		int star;
		
		public Sky(int star) {
			this.star = star;
		}
		
		public int hasCode() {
			return Objects.hash(star);
		}
		
		@Override
		public boolean equals(Object o) {
			return this.hashCode() == ((Sky)o).hashCode();
		}
	}

	public static void main(String[] args) {
		
		
		ArrayList<People> p = new ArrayList<>();
		p.add(new People("aa",11));
		p.add(new People("bb",22));
		p.add(new People("cc",8));
		p.add(new People("dd",7));
		
//		Collections.sort(p, (a, b) -> a.age - b.age);
		for(People a : p) {
			System.out.println(a.age);
		}
//		System.out.println(p);
		
		ArrayList<Integer> numbers = new ArrayList<>();

	    numbers.add(10);
	    numbers.add(20);
//	    numbers.add(30);
	    numbers.add(40);
	    numbers.add(50);

//	    if (numbers.removeIf(n -> n % 3 == 0)) {
//	        System.out.println(numbers);
//	    }
	    
	    System.out.println(numbers.removeIf(n -> n % 3 == 0));
	    
	    Collections.reverse(numbers);
	    System.out.println(numbers);
	    
	    People p1 = new People("kk", 10);
	    System.out.println(p1.hashCode());

	    System.out.println(Objects.hashCode(p1));
	    
	    int[] arr = new int [3];
	    arr[0] = 10;
	    System.out.println("arr[0] 의 값은 : " + arr[0]); // 10이 출력된다.
	    method1(arr); // arr 가 가리키고 있는 heap 의 주소값을 전달한다.
	    System.out.println("arr[0] 의 값은 : " + arr[0]); // 20이 출력된다.
	    
	    int[] kk = {1,2,3};
	    System.out.println(Arrays.toString(kk));
	    
	    Sky s = new Sky(7);
	    Sky s1 = new Sky(7);
	    System.out.println(s.equals(new Sky(7)));
	    
	    String ss = "abcde";
	    System.out.println(ss.substring(2));
	    
	    Queue<Integer> q = new LinkedList<Integer>();
	    

	}


}
