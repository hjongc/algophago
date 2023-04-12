package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[M][0];
		
		for (int i = 0; i<M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
			return o1[2] - o2[2];
		});
		
		int[][] distance = new int[M][N];
		
		boolean[][] visited = new boolean[M][N];
		
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		pq.offer(new int[] {0, 0, 0});
		for (int i = 0; i<M; i++) {
			Arrays.fill(distance[i], 2147483647);
		}
		distance[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (visited[tmp[0]][tmp[1]]) continue;
			visited[tmp[0]][tmp[1]] = true;
			if (tmp[0] == N-1 && tmp[1] == M-1) break;
			
			for (int a = 0; a<4; a++) {
				if (tmp[0] + dx[a] < M && tmp[1] + dy[a] < N && tmp[0] + dx[a] >= 0 && tmp[1] + dy[a] >= 0 && !visited[tmp[0]+dx[a]][tmp[1]+dy[a]]) {
					int tmpDistance = map[tmp[0]+dx[a]][tmp[1]+dy[a]] == '1' ? 1 : 0;
					if (distance[tmp[0]+dx[a]][tmp[1]+dy[a]] > distance[tmp[0]][tmp[1]] + tmpDistance) {
						distance[tmp[0]+dx[a]][tmp[1]+dy[a]] = distance[tmp[0]][tmp[1]] + tmpDistance;
						pq.offer(new int[] {tmp[0] + dx[a], tmp[1] + dy[a], distance[tmp[0]+dx[a]][tmp[1]+dy[a]]});
					}
				}
			}
		}
		System.out.println(distance[M-1][N-1]);
	}
}
