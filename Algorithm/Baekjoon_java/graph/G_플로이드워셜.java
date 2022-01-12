package graph;

import java.util.Arrays;
import java.util.Scanner;

public class G_�÷��̵���� {
	
	static final int INF = (int) 1e9; // ���Ѵ�� 10�� ����
	static int n, m; // n : ����� ����, m : ������ ����
	static int[][] graph = new int[501][501]; // �׷���

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
		
        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        for(int i = 0; i < 501; i++) {
        	Arrays.fill(graph[i], INF);
        }
        
        // �ڱ� �ڽſ��� �ڱ� �ڽ����� ���� ����� 0���� �ʱ�ȭ
        for(int a = 1; a <= n; a++) {
        	for(int b = 1; b <= n; b++) {
        		if(a == b) graph[a][b] = 0;
        	}
        }
        
        // �� ������ ���� ������ �Է� �޾�, �� ������ �ʱ�ȭ
        for(int i = 0; i < m; i++) {
        	// A���� B�� ���� ����� C��� ����
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	graph[a][b] = c;
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
        for(int a = 1; a <= n; a++) {
        	for(int b = 1; b <= n; b++) {
        		// ������ �� ���� ���, ����(INFINITY)�̶�� ���
        		if(graph[a][b] == INF) {
        			System.out.print("INFINITY ");
        		}
        		// ������ �� �ִ� ��� �Ÿ��� ���
        		else {
        			System.out.print(graph[a][b] + " ");
        		}
        	}
        	System.out.println();
        }
        
        

	}

}
