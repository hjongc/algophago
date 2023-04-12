package day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1238_파티 {
	static class Pair implements Comparable<Pair>{
		int w;
		int v;
		
		Pair(int w, int v) {
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			// 가중치를 기준으로 오름차순 정렬 
			return this.w - o.w;
		}
	}
	static int N, M, X, max;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static List<Pair>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 숫자 
		M = Integer.parseInt(st.nextToken()); // 간선 숫자 
		X = Integer.parseInt(st.nextToken()); // 도착지
		
		list = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Pair>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Pair(w,v));
		}
		
		max = 0;
		int[] minToX = new int[N+1]; 
		
		for (int i=1; i<=N; i++) {
			int tmp = 0;
			
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			int start = i;
			int end = X;
			dijkstra(start);
			
			minToX[i] += dist[end];
			
			if (i==end) {
				for (int j=1; j<=N; j++) {
					minToX[j] += dist[j];
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			max = Math.max(max, minToX[i]);
		}
		System.out.println(max);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		boolean[] visit = new boolean[N+1];
		
		dist[start] = 0;
		pq.add(new Pair(0, start));
		
		while (!pq.isEmpty()) {
			Pair curP = pq.poll();
			int cur = curP.v;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Pair next : list[cur]) {
				
				if (dist[next.v] > dist[cur]+next.w) {
					dist[next.v] = dist[cur]+next.w;
					pq.add(new Pair(dist[next.v], next.v));
				}
			}
		}
	}
}
