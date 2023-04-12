package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] edges = new ArrayList[N+1];
		
		for (int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (edges[start] == null) edges[start] = new ArrayList<>();
			if (edges[end] == null) edges[end] = new ArrayList<>();
			edges[start].add(end);
			edges[end].add(start);
		}
		
		boolean[] visited = new boolean[N+1];
		
		int ans = 0;
		for (int i = 1; i<=1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (edges[i] == null) continue;
				Queue<int[]> queue = new LinkedList<int[]>();
				for (int tmp : edges[i]) {
					queue.offer(new int[] {tmp, 1});
				}
				while(!queue.isEmpty()) {
					int[] out = queue.poll();
					int cur = out[0];
					int cnt = out[1];
					if (visited[cur]) continue;
					ans++;
					visited[cur] = true;
					
					if (cnt == 2) continue;
					if (edges[cur] == null) continue;
					for (int tmp : edges[cur]) {
						if (!visited[tmp]) queue.offer(new int[] {tmp, cnt+1});
					}
				}
			}
		}
		System.out.println(ans);
	}
}

