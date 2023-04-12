package day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {
	
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
	
	static int N, E;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static List<Pair>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Pair>();
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Pair(w, v));
			list[v].add(new Pair(w, u));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 두가지 경우가 있다.
		// 1. 1 => v1 => v2 => N
		// 2. 1 => v2 => v1 => N
		boolean canA = true;
		boolean canB = true;
		
		int sumA = 0;
		int sumB = 0;
		
		
		// 1에서 시작하는 경우 
		Arrays.fill(dist, INF);
		dist[1] = 0;
		dijkstra(1);
		
		if (dist[v1] == INF) canA = false;
		if (dist[v2] == INF) canB = false;
		
		sumA += dist[v1];
		sumB += dist[v2];
		
		// v1에서 시작하는 경우 
		Arrays.fill(dist, INF);
		dist[v1] = 0;
		dijkstra(v1);
		
		if (dist[v2] == INF) canA = false;
		if (dist[N] == INF) canB = false;
		
		sumA += dist[v2];
		sumB += dist[N];
		
		// v2에서 시작하는 경우 
		Arrays.fill(dist, INF);
		dist[v2] = 0;
		dijkstra(v2);
		
		if (dist[N] == INF) canA = false;
		if (dist[v1] == INF) canB = false;
		
		sumA += dist[N];
		sumB += dist[v1];
		
		if (!canA && !canB) {
			System.out.println(-1);
		}else if (!canA && canB) {
			System.out.println(sumB);
		}else if (canA && !canB) {
			System.out.println(sumA);
		}else {
			System.out.println(Math.min(sumA, sumB));
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		boolean[] visit = new boolean[N+1];
		
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
