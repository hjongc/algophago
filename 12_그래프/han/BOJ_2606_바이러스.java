package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
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
				Queue<Integer> queue = new LinkedList<Integer>();
				for (int tmp : edges[i]) {
					queue.offer(tmp);
				}
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					if (visited[cur]) continue;
					ans++;
					visited[cur] = true;
					
					if (edges[cur] == null) continue;
					for (int tmp : edges[cur]) {
						if (!visited[tmp]) queue.offer(tmp);
					}
				}
			}
		}
		System.out.println(ans);
	}
}

