package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		// 1명씩 다른 친구와의 거리를 모두 구한다.
		// 구하고 나서 그 합을 구하여 최솟값과 비교한다.
		int minN = 0;
		int min = Integer.MAX_VALUE;
		
		Queue<int[]> que;
		boolean[] visited;
		int[] dist;
		int d;
		int dSum;
		for (int i=1; i<=N; i++) {
			que = new ArrayDeque<int[]>();
			visited = new boolean[N+1];

			dist = new int[N+1];
			d = 0;
			dSum = 0;
			
			int start = i;
			visited[start] = true;
			dist[start] = d;
			
			que.add(new int[] {start, d});
			
			while (!que.isEmpty()) {
				int[] curNode = que.poll();
				
				int curN = curNode[0];
				int curD = curNode[1];
				
				for (int j=0; j<list[curN].size(); j++) {
					int nextN = list[curN].get(j);
					if (visited[nextN]) continue;
					
					visited[nextN] = true;
					dist[nextN] = curD+1;
					dSum += dist[nextN];
					
					que.add(new int[] {nextN, dist[nextN]});
				}
			}
			
			if (min > dSum) {
				minN = i;
				min = dSum;
			}
		}
		System.out.println(minN);
	}
}
