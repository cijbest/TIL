package graph;

import java.util.*;

public class G_순위 {

	static int solution(int n, int[][] results) {
        final int INF = (int) 1e9; // 무한대로 10억 설정
        int[][] graph = new int[101][101]; // 그래프
        
        // 최단 거리 테이블을 모두 무한으로 초기화
        for(int i = 0; i < 101; i++) {
        	Arrays.fill(graph[i], INF);
        }
        
        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for(int a = 1; a <= n; a++) {
        	for(int b = 1; b <= n; b++) {
        		if(a == b) graph[a][b] = 0;
        	}
        }
        
        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for(int i = 0; i < results.length; i++) {
        	// A에서 B로 가는 비용은 C라고 설정
        	graph[results[i][0]][results[i][1]] = 1;
        }
        
        // 점화식에 따라 프로이드 워셜 알고리즘을 수행
        for(int k = 1; k <= n; k++) {
        	for(int a = 1; a <= n; a++) {
        		for(int b = 1; b <= n; b++) {
        			graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        		}
        	}
        }
        
        // 수행된 결과를 출력
        int answer = 0;
        for(int a = 1; a <= n; a++) {
        	int cnt = 0;
        	
        	for(int b = 1; b <= n; b++) {
        		// 이긴 쪽 중심으로 기록했기 때문에 양쪽 다 경기를 치뤘는지 확인해줘야 한다.
        		if(a != b && (graph[a][b] != INF || graph[b][a] != INF)) {
                    cnt++;
                } 
        	}
        	// 순위를 알 수 있는 노드 : 모든 노드와 한 번씩 경기를 치른 노드(걸친 것 포함 a->b, b->c, a->c)
        	if(cnt == n-1) answer++;
        }
        
        /* 위와 같은 방식이다.
        // 수행된 결과를 출력
        int cnt = 0;
        for(int a = 1; a <= n; a++) {
            boolean flag = true;
        	for(int b = 1; b <= n; b++) {
        		// 예측 불가능한 경우
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
