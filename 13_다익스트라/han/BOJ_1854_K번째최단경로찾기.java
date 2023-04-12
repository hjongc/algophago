package han;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1854_K번째최단경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<int[]>[] edges = new ArrayList[N+1];
		for (int i = 1; i<=N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			edges[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		PriorityQueue<Integer>[] distance = new PriorityQueue[N+1];
		for (int i = 1; i<=N; i++) {
			distance[i] = new PriorityQueue<>((Integer o1, Integer o2) -> {
				return o2 - o1;
			});
		}
		
		distance[1].add(0);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[1] - o2[1];
		});
		
		pq.offer(new int[] {1, 0});
		
		while(!pq.isEmpty()) {
			int[] out = pq.poll();
			
			for (int[] tmp : edges[out[0]]) {
				if (distance[tmp[0]].size() < K) {
					distance[tmp[0]].add(tmp[1] + out[1]);
					pq.add(new int[] {tmp[0], tmp[1] + out[1]});
				} else if (distance[tmp[0]].peek() > tmp[1] + out[1]) {
					distance[tmp[0]].poll();
					distance[tmp[0]].add(tmp[1] + out[1]);
					pq.add(new int[] {tmp[0], tmp[1] + out[1]});
				}
			}
		}
		
		for (int i = 1; i<=N; i++) {
			if (distance[i].size() != K) bw.write("-1\n");
			else bw.write(distance[i].peek()+"\n");
		}
		bw.flush();
	}
}
