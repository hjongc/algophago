package day0402;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2660_회장뽑기 {
	static boolean[][] adjArr;
	static int min, N;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<Integer>();
	static Queue<int[]> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		adjArr = new boolean[N+1][N+1];
		min = Integer.MAX_VALUE;
		
		
		while (true){
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			if (u==-1 && v==-1) break;
			
			adjArr[u][v] = true;
			adjArr[v][u] = true;
		}
		
		
		for (int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			que = new ArrayDeque<int[]>();
			
			bfs(i);
		}
		
		System.out.printf("%d %d\n", min, list.size());
		String s = "";
		for (int x: list) {
			s += x+" ";
		}
		System.out.println(s);
		
	}
	private static void bfs(int start) {
		
		que.add(new int[] {start, 1});
		visited[start] = true;
		int visitCnt = 1;
		
		while (!que.isEmpty()) {
			int[] curNode = que.poll();
			int cur = curNode[0];
			int d = curNode[1];
			
			if (d > min) break;
			
			for (int i=1; i<=N; i++) {
				if (!adjArr[cur][i]) continue;
				if (visited[i]) continue;
				
				visited[i] = true;
				visitCnt++;
				que.add(new int[] {i, d+1});
			}
			
			if (visitCnt == N) {
				if (min == d) list.add(start);
				else if (min > d) {
					min = d;
					list = new ArrayList<Integer>();
					list.add(start);
				}
				break;
			}

			
		}
	}
}
