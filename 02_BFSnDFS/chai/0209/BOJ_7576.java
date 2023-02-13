import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
//import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


// 처음에는 1인 토마토 지점에서 각각 BFS를 시작하면 될 것이라 생각함.
// 하지만 시간제한이 이전의 태스크보다 적었고 다른 생각을 해야했음.
// 생각이 나지 않아 바킹독 강의에서 처음에 1인 토마토를 큐에 넣는다는 힌트를 얻었음.

// 실패지점1. 큐에서 뺄 떄 zeroCnt-- 연산을 했음.
// 그래서 BFS는 정상적으로 작동했으나 
// zeroCnt가 0보다 커야하는 케이스에서 0인 경우가 발생했음.
// 그래서 본능적으로 큐에서 더할 때 zeroCnt--연산을 했고 정답이었다.
// 그 이유에 대해서는 추후에 생각해봤다.
// 그 이유는 큐에서 뺄 때 연산을 한다면 빼기연산이 되지 않아야할 시작지점도
// 중복적으로 빼지기 때문이다. 
public class BOJ_7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // col
		int N = Integer.parseInt(st.nextToken()); // row
	
		Deque<int[]> que = new ArrayDeque<>();
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M]; 
		int zeroCnt = 0; // 익어야하는 토마토 수 파악
		int minDays = 0; // 전체 토마토가 최소 일  
		
		// 방향도우미
		int[] dy = {1, -1, 0, 0}; // 상하좌우 
		int[] dx = {0, 0, -1, 1}; 
		
		// 초기 입력 시에 1인 경우 que에 입력하기
		// 그리고 0 갯수 파악하기 
		// 토마토 없는 칸은 -1 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				
				if (tmp == -1) {
					dist[i][j] = tmp; // dist에 토마토 없는 칸 표시 
				}
				else if (tmp == 0) {
					zeroCnt++; // 익어햐하는 토마토 수 파악 
				}
				else { // tmp == 1 
					que.addLast(new int[] {i,j}); // 시작점 모두 que에 넣기 
					
				}
			}
		}
		// BFS 시작하기
		int[] cur;
		while (!que.isEmpty()) {
			cur = que.pollFirst();
			
			for (int d=0; d<4; d++) {
				int ny = cur[0] + dy[d];
				int nx = cur[1] + dx[d];
				
				// 범위조건 
				if (ny<0 || ny>=N || nx<0 || nx>=M) continue;
				// 제한조건 1: map[ny][nx] != 0 방문 x (시작지점 혹은 토마토가 없는 위치)
				// 제한조건 2: dist[ny][nx] == -1 (토마토가 없는 위치)
				// 제한조건 3: dist[ny][nx] > 0 (이미 방문한 위치)
				if (map[ny][nx]!=0 || dist[ny][nx]==-1 || dist[ny][nx] > 0) continue;
				que.addLast(new int[] {ny, nx});
				zeroCnt--;
				dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
				minDays = dist[ny][nx];
			}
			
		}
		if (zeroCnt > 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(minDays);
		}
	}
}
