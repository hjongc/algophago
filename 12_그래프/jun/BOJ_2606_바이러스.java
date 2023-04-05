import java.util.Scanner;

public class BOJ_2606_바이러스 {
	static int n;
	static boolean[][] com;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 컴퓨터 수
		int line = sc.nextInt(); // 바이러스 수

		// 연결 노드 표현
		com = new boolean[n + 1][n + 1];
		for(int i = 0; i < line; i++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			
			com[c1][c2] = true;
			com[c2][c1] = true;
		}
		
		visited = new boolean[n + 1];
		visited[1]= true;
		cnt = 0;
		DFS(1);
		System.out.println(cnt);
		
	}
	
	public static void DFS(int num) {
		for(int i = 1; i <= n; i++) {
			// 같은 숫자가 아니라면
			if(i != num) {
				// 노드가 연결되어 있고 && 이미 방문하지 않았다면
				if(com[num][i] && !visited[i]) {
					visited[i] = true;
					cnt++;
					//System.out.println("node : " + i);
					//System.out.println("cnt : " + cnt);
					DFS(i);
				}
			}
		}
		
	}
}
