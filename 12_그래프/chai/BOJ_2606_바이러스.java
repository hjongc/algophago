package day0401;

import java.util.Scanner;

public class BOJ_2606_바이러스 {
	static int n;
	static int[] nums;
	static boolean[] visited;
	static boolean[][] adjArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		
		nums = new int[n+1];
		adjArr = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			
			adjArr[u][v] = true;
			adjArr[v][u] = true;
		}
		
		visited[1] = true;
		dfs(0, 1);
		
		int cnt = 0;
		for (int i=2; i<=n; i++) {
			if (visited[i]) cnt++;
		}
		System.out.println(cnt);
	}
	
	private static void dfs(int d, int cur) {
		if (d==2) {
			return;
		}
		
		for (int i=1; i<=n; i++) {
			if (!adjArr[cur][i]) continue;
			visited[i] = true;
			dfs(d+1, i);
		}
	}
}

