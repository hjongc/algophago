import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_117792_최소비용구하기2 {

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		int w;
		// 간선과 가중치
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int INF = Integer.MAX_VALUE;
	static int n = 0;	// n개의 도시
	static int m = 0;	// m개의 버스
	static ArrayList<Node>[] adjList;	// 인접 리스트
	static int[] dist;	// 최단 길이 저장할 배열
	static boolean[] visited;	// 방문했는지 배열
	static int[] path;	// 방문했는지 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		// 방향 그래프가 주어지면 주어진 시작점에서
		// 다른 모든 정점으로의 최단 경로를 구하는 프로그램
		
		// 도시 개수 n과 버스 m
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		
		// 인접리스트
		adjList = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 최단 길이 저장 배열 + 초기는 무한대 값 넣어둠
		dist = new int[n + 1];
		Arrays.fill(dist, INF);
		
		// 간선 입력
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 인접 리스트에 노드 추가
			adjList[a].add(new Node(b, w));
		}
		
		
		// 구간의 출발점 + 도착점
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n + 1];
		path = new int[n + 1];
		
		// 시작노드에서 다익스트라 진행
		dijkstra(start);
		
		// 최소 비용 출력
		sb.append(dist[end] + "\n");
		
		// end에서 거꾸로 오다보면 start가 된다
		ArrayList<Integer> list = new ArrayList<>();
		int node = end;
		int cnt = 0;
		while(true) {
			list.add(node);
			cnt++;
			if(node == start) break;
			node = path[node];
		}
		
		// 경로에 포함되어 있는 도시 개수(출발 도착 포함)
		sb.append(cnt + "\n");
		
		// 경로를 도시 순서대로 출력
		for(int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.print(sb);
	}
	
	
	// 시작정점 입력 : 여기에서 저기까지 가는 경로
	// 거리를 저장할 배열을 맨 처음에는 INF로 초기화
	// 아직 방문하지 않은 점들이 가지고 있는 값과, 
	// 현재 정점에서 방문하지 않은 정점까지 가중치의 합이 작다면 변경 
	static void dijkstra(int start) {
		
		// 시작 노드와의 거리는 0으로 시작한다
		dist[start] = 0;
		
		// 시작 정점 제외 정점을 탐색한다
		for(int i = 0; i < n - 1; i++) {
			// 처음에는 최댓값, 존재치 않는 -1로 시작
			int min = INF;
			int idx = -1;

			// 방문하지 않은 정점 중 dist가 가장 짧은 것을 골라서 이동
			for(int j = 1; j <= n; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			// 이동할 게 없다면 여전히 -1
			if(idx == -1) break;
			
			// idx 정점으로 이동했다면 방문하고
			visited[idx] = true;
			
			// idx 정점에 연결되어 있는 노드들(node) 갱신
			for(Node node : adjList[idx]) {
				// 연결되어 있는 노드를 방문하지 않았는데
				// 그 노드 현재 dist보다 idx 정점을 들려서 가는게 더 작다면
				// 즉, dist[idx] idx까지 온 다음에, node.w 둘 사이의 가중치를 더한 것
				if(!visited[node.v] && dist[node.v] > dist[idx] + node.w) {
					// dist를 갱신하고
					dist[node.v]= dist[idx] + node.w;
					// 어디서 왔는지 갱신
					path[node.v] = idx;
				}
			}
		} // 시작 정점 빼고 탐색 끝
	}
	
}
