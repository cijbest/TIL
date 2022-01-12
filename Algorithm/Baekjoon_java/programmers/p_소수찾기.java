package programmers;

import java.util.*;

public class p_소수찾기 {
	
	static HashSet<Integer> set = new HashSet<>();
    
	static boolean isPrime(int num) {
		if(num < 2) return false;
		
		for(int i = 2; i < (int)Math.sqrt(num)+1; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	static void permutation(String str, String numbers) {
		if(!str.equals("")) {
			set.add(Integer.valueOf(str));
		}
		
		for(int i = 0; i < numbers.length(); i++) {
			permutation(str+numbers.charAt(i), numbers.substring(0, i)+numbers.substring(i+1));
		}
	}
	
    static int solution(String numbers) {
        int answer = 0;
        
        // 모든 경우의 수 찾기(순열)
        permutation("", numbers);
        
        // 소수 찾기
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            if(isPrime(it.next())){
                answer++;
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String[] data = {"17", "011"};
		
		for(int i = 0; i < data.length; i++) {
			System.out.println(solution(data[i]));
			set.clear();
		}
		

	}

}
