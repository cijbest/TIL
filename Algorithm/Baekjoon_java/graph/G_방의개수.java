package graph;

import java.util.*;

public class G_방의개수 {
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int hashCode() {
			return Objects.hash(x, y);
		}
		
		public boolean equals(Object o) {
			return this.x == ((Node)o).x && this.y == ((Node)o).y;
		}
	}
	
	static ArrayList<Node> makeEdgeList(Node node){
		ArrayList<Node> list = new ArrayList<>();
		list.add(node);
		return list;
	}

	static int solution(int[] arrows) {
        int answer = 0;
        int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        // 지나온 노드와 간선 저장
        HashMap<Node, ArrayList<Node>> visited = new HashMap<>();
        
        // 시작위치
        Node now_node = new Node(0, 0);
        visited.put(now_node, new ArrayList<Node>());
        
        // 지났던 노드를 다시 지나면 방이 생긴다.
        for(int i = 0; i < arrows.length; i++){
        	
        	// 간선이 교차하는 부분을 노드를 통해 찾아내기 위해 탐색 길이를 2배로 늘려 탐색
        	for(int j = 0; j < 2; j++) {
	            int nx = now_node.x + dir[arrows[i]][0];
	            int ny = now_node.y + dir[arrows[i]][1];
	            Node next_node = new Node(nx, ny);
	            
	            // 방문하지 않은 노드일 때
	            if(!visited.containsKey(next_node)) {
	            	// 노드 추가
	            	visited.put(next_node, makeEdgeList(now_node));
	            }
	            // 방문한 노드면서 처음으로 생긴 간선일 때
	            else if(visited.containsKey(next_node) && !(visited.get(next_node).contains(now_node))) {
	            	// 방 개수 추가
		            answer++;
	            }
	            
	            // 간선 추가
	            visited.get(next_node).add(now_node);
            	visited.get(now_node).add(next_node);
	            
	            
	            // 위치 이동
	            now_node = next_node;
	        }
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
		System.out.println(solution(arrows));
		
		
	}

}
