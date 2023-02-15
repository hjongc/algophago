import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5427 {
	public static void main(String[] args) throws IOException {
		// 먼저 불이 퍼지는 화재 지도를 만든다.
		// 화재 지도에는 해당 지점까지 불이 전파되는 시간이 저장된다.
		
		// 이후 지훈이의 탈출지도를 만든다.
		// 이때 상근이가 해당 지점에 불보다 늦게 도착한다면 해당 위치에는 갈 수 없다.
		
		// 기본 맵은 boolean[R+2][C+2]로 만들고, 벽은 false로 한다. 
		// 화재&탈출지도는 int[R+2][C+2]로 만들고, 0 or R+1에 도착한다면해당 위치까지 가장 빠른 시간을 출력한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[h+2][w+2]; // 초기 지도
			int[][] fire = new int[h+2][w+2];
			int[][] exit = new int[h+2][w+2];
			int[] sg = new int[2];
			
			Deque<int[]> que = new ArrayDeque<>();
			
			// 좌표 도우미
			int[] dy = new int[] {1, -1, 0, 0}; // 상하좌우 
			int[] dx = new int[] {0, 0, -1, 1};
			
			// 첫 화재지점을 큐에 넣어준다.
			// 상근이의 첫 위치를 변수에 저장해둔다.
			// 탈출지도, 화재지도를 -1로 초기화 한다.(가장자리 제외)
			for (int i=0; i<h; i++) {
				String tmp = br.readLine();
				for (int j=0; j<w; j++) {
					// 벽이면 false
					// 길이면 true
					fire[i+1][j+1] = -1;
					exit[i+1][j+1] = -1;
					if (tmp.charAt(j) != '#') {
						map[i+1][j+1] = true;
					}
					// 상근이의 위치 저장
					if (tmp.charAt(j) == '@') {
						sg[0] = i+1;
						sg[1] = j+1;
						exit[i+1][j+1] = 0;
					}
					// 화재 초기위치를 큐에 넣어준다. (여러 군데일수도?)
					if (tmp.charAt(j) == '*') {
						fire[i+1][j+1] = 0;
						que.addLast(new int[] {i+1, j+1}); // y,x
					}
				}
			}

			while (!que.isEmpty()) {
				int[] cur = que.pollFirst();
				for(int d=0; d<4; d++) {
					int ny = cur[0] + dy[d];
					int nx = cur[1] + dx[d];
					
					// 범위조건
					// 가장자리이면 안됨
					// 0 or R+1, C+1
					if (ny<=0 || ny>=h+1 || nx<=0 || nx>=w+1) continue;
					// 제한조건
					// 1. 벽이면 안됨
					// 2. 이미 불이 퍼진 곳이면 안됨 (fire >= 0)
					if (map[ny][nx]==false || fire[ny][nx]>=0) continue;
					
					// fire에 불이 도달한 시간 저장
					fire[ny][nx] = fire[cur[0]][cur[1]] + 1;
					
					// 범위,제한조건을 통과한 지점은 불이 갈 수 있는 위치
					// 큐에 넣어준다.
					que.addLast(new int[] {ny, nx});
				}
			}
			
			// 상근이 탈출지도
			que.addLast(sg); // 상근이 출발위치
			boolean canExit = false;
			while (!que.isEmpty()) {
				int[] cur = que.pollFirst();
				
				for(int d=0; d<4; d++) {
					int ny = cur[0] + dy[d];
					int nx = cur[1] + dx[d];
					
//					System.out.println(1);
					// 종료조건 
					if (ny<=0 || ny>=h+1 || nx<=0 || nx>=w+1) {
						sb.append(exit[cur[0]][cur[1]]+1+"\n");
						canExit = true;
						break;
					}
					if (canExit == true) break;
					
					// 제한조건 
					// 1. 벽이면 안되고
					// 2. 이미 상근이 방문한 곳 x 
					// 3. 불 퍼진 곳 x + fire가 -1이 아니어야함....
					// fire==-1로 벽 체크하다가 오래걸림 
					if (map[ny][nx]==false || exit[ny][nx]>=0 ) continue;
					if (fire[ny][nx] != -1 && fire[ny][nx]<=exit[cur[0]][cur[1]]+1) continue;
			
					exit[ny][nx] = exit[cur[0]][cur[1]] + 1;
					que.addLast(new int[] {ny, nx});
				}	
			}
			if (canExit == false) sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
	}
}
