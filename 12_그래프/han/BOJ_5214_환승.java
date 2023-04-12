package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5214_환승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] hypertube = new int[M][K];
		List<Integer>[] tubes = new ArrayList[N+1];
		
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<K; j++) {
				int tmpStation = Integer.parseInt(st.nextToken());
				
				// hypertube[i][j] : i번째 hypertube가 갈 수 있는 역들 정리 
				hypertube[i][j] = tmpStation;
				if (tubes[tmpStation] == null) tubes[tmpStation] = new ArrayList<>();
				
				// tubes : 해당 역에서 갈 수 있는 hypertube 정리
				tubes[tmpStation].add(i);
			}
			Arrays.sort(hypertube[i]);
		}
		
		List<Integer> start = new ArrayList<>();
		if (N ==1) {
			System.out.println(1);
			return;
		}
		// 시작 hypertube 를 queue에 집어넣기
		for (int i = 0; i<M; i++) {
			if (hypertube[i][0] == 1) start.add(i);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		boolean[] visited = new boolean[M];
		boolean[] visitedSt = new boolean[N+1];
		visitedSt[1] = true;
		for (int tmp : start) {
			queue.offer(new int[] {tmp, 1});
		}
		
		// hypertube 방문 체크, 
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if (visited[tmp[0]]) continue;
			visited[tmp[0]] = true;
			
			for (int station : hypertube[tmp[0]]) {
				if (station == N) {
					System.out.println(tmp[1] + 1);
					return;
				}
				if (visitedSt[station]) continue;
				visitedSt[station] = true;
				for (int nextTube : tubes[station]) {
					if (visited[nextTube]) continue;
					queue.offer(new int[] {nextTube, tmp[1]+1});
				}
			}
		}
		System.out.println(-1);
	}
}
