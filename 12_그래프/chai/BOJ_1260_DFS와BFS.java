package day0329;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFS와BFS {
	static int N;
	static int[] sel;
	static boolean[] visited;
	static boolean[][] map;
	
	static Queue<Integer> que = new ArrayDeque<Integer>();
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		int st = sc.nextInt();
		
		map = new boolean[N+1][N+1];
		for (int i=0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = true;
			map[y][x] = true;
		}
		
		visited = new boolean[N+1];
		visited[st] = true;
		sb.append(st).append(' ');
		DFS(st);
		sb.append('\n');
		
		visited = new boolean[N+1];
		que.add(st);
		visited[st] = true;
		BFS();
		System.out.println(sb);
	}
	
	private static void DFS(int cur) {	
		for (int i=1; i<=N; i++) {
			if (visited[i] || !map[cur][i]) continue;
			sb.append(i).append(' ');
			visited[i] = true;
			DFS(i);
		}
	}
	
	private static void BFS() {
		while (!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur).append(' ');
			for (int i=1; i<=N; i++) {
				if (visited[i] || !map[cur][i]) continue;
				visited[i] = true;
				que.add(i);
			}
		}
		
	}
}
