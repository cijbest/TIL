package graph;

import java.util.*;

public class G_���� {

	static int solution(int n, int[][] results) {
        final int INF = (int) 1e9; // ���Ѵ�� 10�� ����
        int[][] graph = new int[101][101]; // �׷���
        
        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        for(int i = 0; i < 101; i++) {
        	Arrays.fill(graph[i], INF);
        }
        
        // �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
        for(int a = 1; a <= n; a++) {
        	for(int b = 1; b <= n; b++) {
        		if(a == b) graph[a][b] = 0;
        	}
        }
        
        // �� ������ ���� ������ �Է� �޾�, �� ������ �ʱ�ȭ
        for(int i = 0; i < results.length; i++) {
        	// A���� B�� ���� ����� C��� ����
        	graph[results[i][0]][results[i][1]] = 1;
        }
        
        // ��ȭ�Ŀ� ���� �����̵� ���� �˰����� ����
        for(int k = 1; k <= n; k++) {
        	for(int a = 1; a <= n; a++) {
        		for(int b = 1; b <= n; b++) {
        			graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        		}
        	}
        }
        
        // ����� ����� ���
        int answer = 0;
        for(int a = 1; a <= n; a++) {
        	int cnt = 0;
        	
        	for(int b = 1; b <= n; b++) {
        		// �̱� �� �߽����� ����߱� ������ ���� �� ��⸦ ġ����� Ȯ������� �Ѵ�.
        		if(a != b && (graph[a][b] != INF || graph[b][a] != INF)) {
                    cnt++;
                } 
        	}
        	// ������ �� �� �ִ� ��� : ��� ���� �� ���� ��⸦ ġ�� ���(��ģ �� ���� a->b, b->c, a->c)
        	if(cnt == n-1) answer++;
        }
        
        /* ���� ���� ����̴�.
        // ����� ����� ���
        int cnt = 0;
        for(int a = 1; a <= n; a++) {
            boolean flag = true;
        	for(int b = 1; b <= n; b++) {
        		// ���� �Ұ����� ���
        		if(a != b && graph[a][b] == INF && graph[b][a] == INF) {
                    flag = false;
                    break;
                } 
        	}
        	if(flag) cnt++;
        }
         */

        return answer;
    }
	
	public static void main(String[] args) {
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5, results));

	}

}
