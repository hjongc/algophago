import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // row 
		int M = Integer.parseInt(st.nextToken()); // col
		
		int[][] map = new int[N][M]; 
		int[][] visit = new int[N][M];
		Deque<int[]> que = new ArrayDeque<>(); 
		
		// 방향도우미 
		int[] dy = new int[] {1, -1, 0, 0}; //상하좌우 
		int[] dx = new int[] {0, 0, -1, 1};
		
		// 초기 입력 
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j); // (int) s.charAt(j) => 49
				visit[i][j] = -1;
			}
		}
		
		// 첨에 1926번처럼 전체순회하려고 했음;
		// BFS 시작 
		visit[0][0] = 1;
		que.addLast(new int[] {0,0});
		
		while (!que.isEmpty()) {
			int[] cur = que.pollFirst();
			for (int i=0; i<4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				
				if (ny<0 || ny>=N ||nx<0 || nx>= M) continue;
				if (visit[ny][nx]>=0 || map[ny][nx]=='0') continue;
				visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
				que.addLast(new int[] {ny, nx});
			}
		}
					
		System.out.println(visit[N-1][M-1]);
	}
}
