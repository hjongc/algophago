package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int[][] edges = new int[N][N];
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<N; j++) {
				edges[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		for (int i = 0; i<N; i++) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[N];
			boolean flag = true;
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int out = queue.poll();
				if (visited[out]) continue;
				visited[out] = true;
				
				map[i][out] = 1;
				if (out == i && flag) { flag = false; map[i][i] = 0; visited[i] = false;}
				
				for (int j = 0; j<N; j++) {
					if (edges[out][j] == 1 && !visited[j]) {
						queue.offer(j);
					}
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

