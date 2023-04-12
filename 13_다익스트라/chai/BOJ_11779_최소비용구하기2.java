package day0412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class BOJ_11779_최소비용구하기2 {
	static class Pair implements Comparable<Pair> {
		int w;
		int v;
		
		Pair(int w, int v) {
			this.w = w;
			this.v = v;
		}
		@Override
		public int compareTo(Pair o) {
			return this.w - o.w;
		}
	}

	static int N, M;
	static List<Pair>[] list;
	static List<Integer> route = new ArrayList<Integer>();
	static int[] dist, from;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		from = new int[N+1];
		
		Arrays.fill(dist, INF);
		
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Pair>();
		}
		
		for (int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			list[u].add(new Pair(w, v));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		dijkstra(start);
		
		find(end);
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		sb.append(route.size()).append("\n");
		
		for (int i=route.size()-2; i>=0; i--) {
			sb.append(route.get(i)+" ");
		}
		sb.append(end);
		System.out.println(sb);
	}
	
	
	private static void dijkstra(int start) {
		boolean[] visit = new boolean[N+1];
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		
		pq.add(new Pair(0, start));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			int curV = cur.v;
			
			if (visit[curV]) continue;
			else visit[curV] = true;
			
			for (Pair pair : list[curV]) {
				if (dist[pair.v] > dist[curV]+pair.w) {
					dist[pair.v] = dist[curV]+pair.w;
					
					from[pair.v] = curV;
					pq.add(new Pair(dist[pair.v], pair.v));
				}
			}
		}
	}
	
	private static void find(int last) {
		if (last == from[last]) return;
		
		route.add(from[last]);
		find(from[last]);
	}
}