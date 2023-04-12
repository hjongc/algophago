package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5719_거의최단경로 {
	/* 맨 처음 생각 
	 * 
	 * 다익스트라를 한 번 돌림 
	 * 최소 거리를 찾고 이용한 간선을 모두 부숨
	 * 
	 * 다익스트라를 계속 돌림
	 * 이전 최소 거리와 동일하다면 간선을 모두 부숨
	 * 이전 최소 거리보다 길다면 채택!
	 * 
	 * 하지만... 반례가 있었다
	 * 1 -> 2 -> 3 -> 4 : 최소경로
	 * 1 -> 2 -> 5 -> 4 : 이것도 최소경로 라면
	 * 
	 * 1 -> 2
	 * 2 -> 3
	 * 3 -> 4
	 * 2 -> 5
	 * 5 -> 4 모두 부수어야 하지만
	 * 
	 * 실제로 돌려보면 
	 * 1 -> 2, 2 -> 3 3 -> 4 만 부수고
	 * 1 -> 2 -> 5 -> 4 라는 최소 길이가 없어졌으므로 2->5, 5->4 간선은 남아있는 문제 발생
	 * 
	 * 흠... 어떡하지
	 * 그래서 동일한 거리로 닿을 수 있으면 저장을 추가로 해주면 되겠다, 그러고 한 번에 부수도록
     * ArrayList 사용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true) {
			
			// *******************입력 받기************************
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int[][] edges = new int[N][N];
			
			for (int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				edges[U][V] = P;
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2)->{
				return o1[1] - o2[1];
			});
			
			// ******************첫 번째 다익스트라******************
			int[] distance = new int[N];
			boolean[] visited = new boolean[N];
			List<Integer>[] before = new ArrayList[N];
			
			Arrays.fill(distance, 2147483647);
			distance[start] = 0;
			
			pq.offer(new int[] {start, 0});
			
			while(!pq.isEmpty()) {
				int[] out = pq.poll();
				if (visited[out[0]]) continue;
				visited[out[0]] = true;
				if (visited[end]) break;
				for (int i = 0; i<N; i++) {
					if (edges[out[0]][i] == 0) continue;
					if (distance[i] > distance[out[0]] + edges[out[0]][i]) {
						distance[i] = distance[out[0]] + edges[out[0]][i];
						
						before[i] = new ArrayList<>();
						before[i].add(out[0]);
						
						pq.offer(new int[] {i, distance[i]});
					} else if (distance[i] == distance[out[0]] + edges[out[0]][i]) {
						before[i].add(out[0]);
					}
				}
			}
			if (!visited[end]) {sb.append("-1\n"); continue;}
			
			// *******************최소 경로였던 간선들 모두 제거****************
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(end);
			visited = new boolean[N];
			while(!queue.isEmpty()) {
				int tmp = queue.poll();
				if (visited[tmp]) continue;
				visited[tmp] = true;
				
				if (before[tmp] == null) continue;
				for (int i : before[tmp]) {
					queue.offer(i);
					edges[i][tmp] = 0;
				}
			}
			
			// ********************두 번째 다익스트라***********************
			distance = new int[N];
			visited = new boolean[N];
			Arrays.fill(distance, 2147483647);
			distance[start] = 0;
			
			pq.clear();
			pq.offer(new int[] {start, 0});
			
			while(!pq.isEmpty()) {
				int[] out = pq.poll();
				if (visited[out[0]]) continue;
				visited[out[0]] = true;
				if (visited[end]) break;
				for (int i = 0; i<N; i++) {
					if (visited[i]) continue;
					if (edges[out[0]][i] == 0) continue;
					if (distance[i] > distance[out[0]] + edges[out[0]][i]) {
						distance[i] = distance[out[0]] + edges[out[0]][i];
						pq.offer(new int[] {i, distance[i]});
					}
				}
			}

			if (!visited[end]) {sb.append("-1\n"); continue;}
			
			sb.append(distance[end]+"\n");
		}
		System.out.print(sb);
	}
}

