package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_1916 {
	
	public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����
    public static int n, m, start, end;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[1001];
	
	static class Node implements Comparable<Node> {
	    int index;
	    int distance;

	    public Node(int index, int distance) {
	        this.index = index;
	        this.distance = distance;
	    }
	    
	    public int getIndex() {
	        return this.index;
	    }

	    public int getDistance() {
	        return this.distance;
	    }
	    
	    @Override
	    public int compareTo(Node other) {
	        if (this.distance < other.distance) {
	            return -1;
	        }
	        return 1;
	    }
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
        // ���� ���� ���� ���� �ִ� ��δ� 0���� �����Ͽ�, ť�� ����
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // ť�� ������� �ʴٸ�
            // ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
            Node node = pq.poll();
            int dist = node.getDistance(); // ���� �������� ��� 
            int now = node.getIndex(); // ���� ���
            // ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
            if (d[now] < dist) continue;
            // ���� ���� ����� �ٸ� ������ ������ Ȯ��
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
		// [1916] �ּҺ�� ���ϱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// �׷��� �ʱ�ȭ
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
		
        // ��� ���� ������ �Է¹ޱ�
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, dist));
		}
		
		// ����, ��
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

        // �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
        Arrays.fill(d, INF);
        
        // ���ͽ�Ʈ�� �˰����� ����
        dijkstra(start);

        System.out.println(d[end]);

	}

}
