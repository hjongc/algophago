package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] edges = new ArrayList[N+1];
		
        // edges 채우기        
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (edges[start] == null) edges[start] = new ArrayList<>();
			if (edges[end] == null) edges[end] = new ArrayList<>();
			edges[start].add(end);
			edges[end].add(start);
		}
		
        // 방문 여부 판단
		boolean[] visited = new boolean[N+1];
		
		int ans = 0;
		for (int i = 1; i<=N; i++) {
			if (!visited[i]) {
				ans++;
				visited[i] = true;
				if (edges[i] == null) continue;
				Queue<Integer> queue = new LinkedList<Integer>();
				for (int tmp : edges[i]) {
					queue.offer(tmp);
				}
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					if (visited[cur]) continue;
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
