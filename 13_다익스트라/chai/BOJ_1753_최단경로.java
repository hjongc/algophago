package day0410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753_최단경로 {
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
	
	static int V, E, K;
	static int[] dist; // K로부터 정점별 최소거리를 담을 배열  
	static List<Pair>[] list; // 간선정보를 담을 리스트 
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt(); // 정점 개수 
		E = sc.nextInt(); // 간선 개수 
		K = sc.nextInt(); // 시작 정점
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		// 무한대로 초기화해준다. 
		Arrays.fill(dist, INF);
		
		for (int i=1; i<=V; i++) {
			list[i] = new ArrayList<Pair>();
		}
		
		// 간선 정보를 입력해준다.
		for (int i=0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			// 가중치를 먼저 
			list[u].add(new Pair(w, v));
		}
		
		// 다익스트라 알고리즘을 작동시킨다. 
		dijkstra(K);
		
		// 다익스트라 종료이후 dist에 저장된 정보를 출력해준다. 
		for (int i=1; i<=V; i++) {
			if (dist[i]==INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

	// 경로시작지점: start
	private static void dijkstra(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); // 가중치가 작은 값부터 뽑아준다. 
		boolean[] visit = new boolean[V+1]; // 방문이 확정된 정점에 대해서 true로 바꿔준다. 
		
		// 경로시작지점을 우선수위큐에 넣어준다.
		// 또한 시작지점은 자기자신에 대해 거리가 0이다.
		pq.add(new Pair(0, start));
		dist[start] = 0;
		
		// 우선순위큐가 비어있을 때까지 반복한다. 
		while (!pq.isEmpty()) {
			//가중치가 가장 작은 간선을 뽑아준다.
			Pair cur = pq.poll();
			
			// 간선이 향하는 정점
			// (이전 정점에서 가르켜 현재로 왔으므로 새로운 출발지점)
			int curV = cur.v; 
			
			// 이미 방문했으면 더이상 방문하지 않는다. 
			// 첫 방문이라면 방문표시를 해준다.
			if (visit[curV]) continue;
			else visit[curV] = true;
			
			// curV와 연결된 모든 간선정보에 대해 
			for (Pair pair: list[curV]) {
				// dist배열에 저장된 다음정점까지의 거리가 
				// curV까지의 가중치합+다음정점의 가중치가 작다면
				// 업데이트해주고 우선순위큐에 넣어준다.
				if (dist[pair.v]>dist[curV]+pair.w) {
					dist[pair.v] = dist[curV]+pair.w;
					pq.add(new Pair(dist[pair.v], pair.v));
				}
			}
		}
	}
}
