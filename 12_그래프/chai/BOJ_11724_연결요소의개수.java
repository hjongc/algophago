package day0328;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {
	static int N;
	static boolean[][] arr;
	static boolean[] visit;
	static Queue<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			arr[u][v] = true;
			arr[v][u] = true;
		}
		
		int cnt = 0;
		for (int i=1; i<=N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			que.add(i);
			bfs();
			cnt++;
		}
		System.out.println(cnt);
	}
	private static void bfs() {
		while (!que.isEmpty()) {
			int cur = que.poll();
			
			for (int i=1; i<=N; i++) {
				if (visit[i] || !arr[cur][i]) continue;
				visit[i] = true;
				que.add(i);
			}
		}
	}
	
	
	
}
