package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, weight;
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return weight-o.weight;
	}
}

public class BOJ_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] edge = new ArrayList[V+1];
		
		for (int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int strt = Integer.parseInt(st.nextToken());
			
			if (edge[strt] == null) edge[strt] = new ArrayList<>();
			
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edge[strt].add(new Node(end, weight));
		}
		
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(dist, 2147483647);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int cur = tmp.end;
			if (visited[cur]) continue;
			visited[cur] = true;
			
			if (edge[cur] == null) continue;
			for (Node i : edge[cur]) {
				if (visited[i.end]) continue;
				if (dist[i.end] > dist[cur] + i.weight) {
					dist[i.end] = dist[cur] + i.weight;
//					pq.offer(new int[] {i[0], dist[i[0]]});
					pq.offer(new Node(i.end, dist[i.end]));
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i<=V; i++) {
			if (dist[i] == 2147483647) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	
}

