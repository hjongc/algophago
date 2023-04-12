package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용구하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<int[]>[] edges = new ArrayList[N+1]; 
		
		for (int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			if (edges[start] == null) edges[start] = new ArrayList<>();
			edges[start].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		int[] D = new int[N+1];
		int[] P = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(D, 2147483647);
		Arrays.fill(P, 2147483647);
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		if (N == 1) {
			System.out.println(edges[start].get(0)[1]);
			System.out.println(1);
			System.out.println(start);
			return;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2)-> {
			return o1[1] - o2[1];
		});
		
		D[start] = 0;
		P[start] = start;
		int count = 1;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (visited[tmp[0]]) continue;
			visited[tmp[0]] = true;
			
			if (edges[tmp[0]] == null) continue;
			for (int[] i : edges[tmp[0]]) {
				if (visited[i[0]]) continue;
				if (D[i[0]] > D[tmp[0]] + i[1]) {
					D[i[0]] = D[tmp[0]] + i[1];
					P[i[0]] = tmp[0];
					pq.offer(new int[] {i[0], D[i[0]]});
				}
			}
			
		}
		StringBuffer sb = new StringBuffer();
		int tmp = end;
		while(tmp != start) {
			sb.insert(0, " "+tmp);
			count++;
			tmp = P[tmp];
		}
		sb.insert(0, start);
		
		System.out.println(D[end]);
		System.out.println(count);
		System.out.println(sb);
	}
}

