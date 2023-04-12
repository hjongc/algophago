package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<int[]>[] edges = new ArrayList[N+1];
		
		for (int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (edges[start] == null) edges[start] = new ArrayList<>();
			if (edges[end] == null) edges[end] = new ArrayList<>();
			edges[start].add(new int[] {end, weight});
			edges[end].add(new int[] {start, weight});
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int U = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		/*
		 * 총 4 가지 경우가 가능
		 * 
		 * 1 -> u -> v -> N
		 * 1 -> v -> u -> N
		 * 1 -> u -> v -> u -> N
		 * 1 -> v -> u -> v -> N
		 * 
		 * 따라서, 
		 * 1->u
		 * 1->v
		 * u->v
		 * u->N
		 * v->N
		 * 을 구해야 함
		 */
		
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		
		queue.offer(new int[] {U, 0});
		Arrays.fill(distance, 214748364);
		distance[U] = 0;
		
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			if (visited[out[0]]) continue;
			visited[out[0]] = true;
			if (visited[N] && visited[1] && visited[V]) break;
			if (edges[out[0]] == null) continue;
			for (int[] edge : edges[out[0]]) {
				if (visited[edge[0]]) continue;
				if (distance[edge[0]] > distance[out[0]] + edge[1]) {
					distance[edge[0]] = distance[out[0]] + edge[1];
					queue.offer(new int[] {edge[0], distance[edge[0]]});
				}
			}
		}
		
		int OneToU = distance[1];
		int UToV = distance[V];
		int UToN = distance[N]; 
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		queue = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		
		queue.offer(new int[] {V, 0});
		Arrays.fill(distance, 214748364);
		distance[V] = 0;
		
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			if (visited[out[0]]) continue;
			visited[out[0]] = true;
			if (visited[N] && visited[1]) break;
			if (edges[out[0]] == null) continue;
			for (int[] edge : edges[out[0]]) {
				if (visited[edge[0]]) continue;
				if (distance[edge[0]] > distance[out[0]] + edge[1]) {
					distance[edge[0]] = distance[out[0]] + edge[1];
					queue.offer(new int[] {edge[0], distance[edge[0]]});
				}
			}
		}
		
		int OneToV = distance[1];
		int VToN = distance[N];
		
		int firstCase = OneToU + UToV + VToN;
		int secondCase = OneToV + UToV + UToN;
		int thirdCase = OneToU + 2 * UToV + UToN;
		int fourthCase = OneToV + 2 * UToV + VToN;
//		System.out.println(firstCase);
//		System.out.println(secondCase);
//		System.out.println(thirdCase);
//		System.out.println(fourthCase);
		int ans = Math.min(Math.min(firstCase, secondCase), Math.min(thirdCase, fourthCase));
		if (ans < 214748364) System.out.println(ans);
		else System.out.println(-1);
	}
}

