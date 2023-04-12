package b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static final int INFINITY = Integer.MAX_VALUE;
	static int V, E, K;
	static List<Node>[] adjList;
	static int[] dist;

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		dist[start] = 0; //시작 노드에서 시작 노드까지의 거리는 0
		
		for(int i=0; i<V-1; i++) {
			int min = INFINITY;
			int idx = -1;
			
			//선택하지 않은 정점 중 dist가 가장 짧은 것을 고름
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break; //선택할 수 없으면 멈춥니다
			visited[idx] = true; //선택
			//갱신할 수 있으면 갱신
			for(int j=0; j<adjList[idx].size(); j++) {
				Node cur = adjList[idx].get(j);
				
				//방문하지 않았고, 연결도 되었고(인접행렬이라면 고려해야함),
				//이미 가지고 있는 값보다 더 작은 값이 있다면 갱신
				if(!visited[cur.v] && dist[cur.v] > dist[idx] + cur.w) {
					//프림은 그 간선이 나보다 작으면 그냥 갱신하는데, 다익스트라는 시작정점으로부터의 최단경로를 모두 고려 (여기까지 온 값 + 앞으로 갈 값)
					dist[cur.v] = dist[idx] + cur.w;
				}
			}
		}
		for(int i=0; i<dist.length; i++) {
			if(dist[i] == INFINITY) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st1.nextToken());
		E = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st2.nextToken()) - 1;

		adjList = new ArrayList[V];
		
		for(int i=0; i<V; i++) adjList[i] = new ArrayList<>();
		dist = new int[V];
		Arrays.fill(dist, INFINITY);
		// adjList[0].add(new Node(0, 0));
		for(int i=0; i<E; i++) {
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st3.nextToken()) - 1;
			int v = Integer.parseInt(st3.nextToken()) - 1;
			int w = Integer.parseInt(st3.nextToken());

			adjList[u].add(new Node(v, w)); //U는 V에 연결된 가중치W의 간선이다
		}
		dijkstra(K);
	}
}