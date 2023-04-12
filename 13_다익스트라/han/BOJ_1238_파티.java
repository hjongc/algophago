package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<int[]>[] edges = new ArrayList[N+1];
		List<int[]>[] reverseEdges = new ArrayList[N+1];
		
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (edges[start] == null) edges[start] = new ArrayList<>();
			edges[start].add(new int[] {end, weight});
			if (reverseEdges[end] == null) reverseEdges[end] = new ArrayList<>();
			reverseEdges[end].add(new int[] {start, weight});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		PriorityQueue<int[]> pq2 = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		
		int[] times = new int[N+1];
		
		// pq는 reverseEdges를 이용해서 계싼한다
		int[] D1 = new int[N+1];
		Arrays.fill(D1, 2147483647);
		boolean[] isVisited = new boolean[N+1];
		D1[X] = 0;
		pq.offer(new int[] {X, 0});
		
		while(!pq.isEmpty()) {
			int[] out = pq.poll();
			if (isVisited[out[0]]) continue;
			isVisited[out[0]] = true;
			
			if (reverseEdges[out[0]] == null) continue;
			for (int[] i : reverseEdges[out[0]]) {
				if (isVisited[i[0]]) continue;
				if (D1[i[0]] > D1[out[0]] + i[1]) {
					D1[i[0]] = D1[out[0]] + i[1];
					pq.offer(new int[] {i[0], D1[i[0]]});
				}
			}
		}
		
		for (int i = 1; i<=N; i++) {
			times[i] = D1[i];
		}
		
		int[] D2 = new int[N+1];
		Arrays.fill(D2, 2147483647);
		isVisited = new boolean[N+1];
		D2[X] = 0;
		pq.offer(new int[] {X, 0});
		
		while(!pq.isEmpty()) {
			int[] out = pq.poll();
			if (isVisited[out[0]]) continue;
			isVisited[out[0]] = true;
			
			if (edges[out[0]] == null) continue;
			for (int[] i : edges[out[0]]) {
				if (isVisited[i[0]]) continue;
				if (D2[i[0]] > D2[out[0]] + i[1]) {
					D2[i[0]] = D2[out[0]] + i[1];
					pq.offer(new int[] {i[0], D2[i[0]]});
				}
			}
		}
		
		for (int i = 1; i<=N; i++) {
			if (D2[i] == 2147483647) times[i] = 2147483647;
			times[i] += D2[i];
		}
		
		int max = 0;
		for (int i = 1; i<=N; i++) {
			if (times[i] > max) max = times[i];
		}
		System.out.println(max);
	}
}
