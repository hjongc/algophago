import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 세로 
		int m = Integer.parseInt(st.nextToken()); // 가로 
		
		// 주어진 도화지 입력할 배열
		int[][] arr = new int[n][m];
		
		// 방문여부 체크할 배열
		boolean [][] visit = new boolean[n][m];
		
		// 방문 성공한 좌표 담을 큐 
		Deque<int[]> que = new ArrayDeque<>();
		
		// 좌표 도우미
		int[] dy = new int[] {1, -1, 0, 0}; // 상하좌우 
		int[] dx = new int[] {0, 0, -1, 1};
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		// 이중 for문으로 visited false && arr[y][x] = 1 인 지점 찾고 
		// 1인 지점에서 BFS 시작 
		// 이어져 있는 그림 큐에 넣고, visited에 표시, cnt++;
		// if cnt > max: max = cnt;
		
		int max = 0; // 최대 그림 넓이 
		int paintingCnt = 0; // 그림 갯수 
		
		for (int y=0; y<n; y++) {
			for (int x=0; x<m; x++) {
				if (visit[y][x]==true || arr[y][x]==0) continue;
				paintingCnt++;
				visit[y][x] = true;
				que.addLast(new int[] {y,x});
				
				int tmpCnt = 0; // 그림 넓이 
				while (!que.isEmpty()) {
					int[] cur = que.pollFirst(); // [y,x]
					tmpCnt++;
					
					// 방향도우미 사용 
					for(int dir=0; dir<4; dir++) {
						int ny = cur[0] + dy[dir];
						int nx = cur[1] + dx[dir];
						if (ny<0 || ny>=n || nx<0 || nx>=m) continue; // 범위를 넘지 않을 떄 
						if (visit[ny][nx]==true || arr[ny][nx] == 0) continue;
						
						visit[ny][nx] = true;
						que.addLast(new int[] {ny,nx});
					}
				}
				if(tmpCnt > max) max = tmpCnt;
				
			}
		}
		System.out.println(paintingCnt);
		System.out.println(max);
	}
}

