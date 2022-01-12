package programmers;

import java.util.*;

public class p_카펫 {
	
	static int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // 카펫 총 개수
        int carpet = brown + yellow;
        
        // 약수 보관 (면 길이는 최소 3이상)
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 3; i < (int)Math.sqrt(carpet)+1; i++){
            if(carpet % i == 0){
                if(i == (int)Math.sqrt(carpet) && Math.sqrt(carpet) == (int)Math.sqrt(carpet)){ // 제곱수
                    arr.add(new int[] {i, i});
                    continue;
                }
                arr.add(new int[] {carpet/i, i});
            }
        }
        
        // brown 개수랑 비교해서 값 구하기
        for(int i = 0; i < arr.size(); i++) {
        	int[] a = arr.get(i);
        	System.out.println(">>"+ a[0]+ "  " +a[1]);
        	if((a[0] + a[1]) * 2 - 4 == brown) {
        		answer = arr.get(i);
        	}
        }

        return answer;
    }

	public static void main(String[] args) {
		int[] a = solution(24, 24);

		System.out.println(a[0]+ "  " +a[1]);
	}

}
