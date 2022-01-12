package programmers;

import java.util.*;

public class p_ī�� {
	
	static int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // ī�� �� ����
        int carpet = brown + yellow;
        
        // ��� ���� (�� ���̴� �ּ� 3�̻�)
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 3; i < (int)Math.sqrt(carpet)+1; i++){
            if(carpet % i == 0){
                if(i == (int)Math.sqrt(carpet) && Math.sqrt(carpet) == (int)Math.sqrt(carpet)){ // ������
                    arr.add(new int[] {i, i});
                    continue;
                }
                arr.add(new int[] {carpet/i, i});
            }
        }
        
        // brown ������ ���ؼ� �� ���ϱ�
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
