package day0404;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11403_경로찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] adjArr = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				adjArr[i][j] = sc.nextInt();
			}
		} 
		
		int[][] ans = new int[N][N];
		for (int i=0; i<N; i++) {
			int[] isConnected = new int[N];
			boolean[] visited = new boolean[N];
			
			Queue<Integer> que = new ArrayDeque<>();
			
			int start = i;
			que.add(start);
			
			while (!que.isEmpty()) {
				int cur = que.poll();
				
				for (int j=0; j<N; j++) {
					if (adjArr[cur][j]==0 || visited[j]) continue;
					
					isConnected[j] = 1;
					visited[j] = true;
					
					que.add(j);
				}
			}
			
			ans[i] = isConnected;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
}
