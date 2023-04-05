package day0330;
import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {
	static int N;
	static int M;
	static boolean[][] arr;
	static boolean[] visited;
	static int checked;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정점의 개수 N 간선의 개수 M
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 정점은 1부터 N사이여서 배열을 만든다
		arr = new boolean[N + 1][N + 1];
		
		// 간선의 개수 M개
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		
		// 방문했는지 배열
		visited = new boolean[N + 1];
		// 확인한 정점 개수
		checked = 1;
		
		// 1에 연결된 숫자들, 그에 연결된 숫자들
		// bfs로 퍼지듯이 탐색해야 하는데 풀다보니 dfs로 풀었네
		visited[1] = true;
		cnt = 1;
		dfs(1);
		
		// 정점에 연결된 정점이 없어서 여기로 올라왔는데
		// 정점을 다 확인하지 않았다면
		// 방문하지 않은 거 찾아가고 카운트 증가
		if(checked != N) {
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					checked++;
					cnt++;
					dfs(i);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	// 정점 num에 연결된 간선들 탐색
	static void dfs(int num) {

		// 간선이 들어왔을 때, 둘 중 하나가 visited라면 카운트 추가 안 함
		// 둘 다 visited에 없다면 카운트 추가
		// 정점에 연결된 정점을 다 봐야해서 대각선으로 반 가르면 안됨
		for(int i = 1; i <= N; i++) {
			// 정점 num과 숫자 i가 연결되어 있다면
			if(arr[num][i]) {
				if(!visited[i]) {
					// 이게 visited가 아니라면 방문 처리
					visited[i] = true;
					// 정점 확인했으면 하나 증가시킴
					checked++;
					// 간선에 연결된 정점 탐색
					dfs(i);
					// 다 확인했다면 **리턴 위치**
					if(checked == N) return;
				}
			}
		}
	}
}
