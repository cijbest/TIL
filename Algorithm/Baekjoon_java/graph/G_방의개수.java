package graph;

import java.util.*;

public class G_���ǰ��� {
	
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
        
        // ������ ���� ���� ����
        HashMap<Node, ArrayList<Node>> visited = new HashMap<>();
        
        // ������ġ
        Node now_node = new Node(0, 0);
        visited.put(now_node, new ArrayList<Node>());
        
        // ������ ��带 �ٽ� ������ ���� �����.
        for(int i = 0; i < arrows.length; i++){
        	
        	// ������ �����ϴ� �κ��� ��带 ���� ã�Ƴ��� ���� Ž�� ���̸� 2��� �÷� Ž��
        	for(int j = 0; j < 2; j++) {
	            int nx = now_node.x + dir[arrows[i]][0];
	            int ny = now_node.y + dir[arrows[i]][1];
	            Node next_node = new Node(nx, ny);
	            
	            // �湮���� ���� ����� ��
	            if(!visited.containsKey(next_node)) {
	            	// ��� �߰�
	            	visited.put(next_node, makeEdgeList(now_node));
	            }
	            // �湮�� ���鼭 ó������ ���� ������ ��
	            else if(visited.containsKey(next_node) && !(visited.get(next_node).contains(now_node))) {
	            	// �� ���� �߰�
		            answer++;
	            }
	            
	            // ���� �߰�
	            visited.get(next_node).add(now_node);
            	visited.get(now_node).add(next_node);
	            
	            
	            // ��ġ �̵�
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
