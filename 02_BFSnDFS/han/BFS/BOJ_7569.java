package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
	
	// static 선언
	static int M, N, H;
	
	// 입력받기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 토마토가 들어갈 grid 선언
		int[][][] grid = new int[M][N][H];
		
		// 0의 갯수 세기 ( 끝났는지 체크용 )
		int zeroNum = 0;
		Queue<int[]> queue = new LinkedList<>();
		
		// 입력 받으면서 0 갯수 세기
		for (int k = 0; k<H; k++) {
			for (int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int i = 0; i<M; i++) {
					int in = Integer.parseInt(st.nextToken());
					grid[i][j][k] = in; 
					if (in == 1) {queue.offer(new int[] {i,j,k});}
					else if (in == 0) zeroNum++;
				}
			}
		}
		
		// 0이 없으면 -> 끝
		if (zeroNum == 0) {System.out.println(0); return;}
		
		// BFS 출발~
		while (!queue.isEmpty()) {
			int[] out = queue.poll();
			int x = out[0];
			int y = out[1];
			int z = out[2];
			int dist = grid[x][y][z];
			
			// dist > 1 : grid의 0을 다른 숫자로 바꾸었다는 뜻이므로 0의 갯수 줄임
			// 왜냐하면 dist = 1 : 맨 처음 토마토
			// dist = -1 : 벽
			// dist = 0 : 아직 토마토가 자라지 않은 곳
			if (dist > 1) zeroNum--;
			if (zeroNum == 0) {System.out.println(dist-1); return;}
			
			if (check(x-1 , y, z) && grid[x-1][y][z] == 0) {
				queue.offer(new int[] {x-1,y,z});
				grid[x-1][y][z] = dist+1;
			}
			if (check(x+1 , y, z) && grid[x+1][y][z] == 0) {
				queue.offer(new int[] {x+1,y,z});
				grid[x+1][y][z] = dist+1;
			}
			if (check(x , y-1, z) && grid[x][y-1][z] == 0) {
				queue.offer(new int[] {x,y-1,z});
				grid[x][y-1][z] = dist+1;
			}
			if (check(x , y+1, z) && grid[x][y+1][z] == 0) {
				queue.offer(new int[] {x,y+1,z});
				grid[x][y+1][z] = dist+1;
				
			}
			if (check(x , y, z-1) && grid[x][y][z-1] == 0) {
				queue.offer(new int[] {x,y,z-1});
				grid[x][y][z-1] = dist+1;
			}
			if (check(x , y, z+1) && grid[x][y][z+1] == 0) {
				queue.offer(new int[] {x,y,z+1});
				grid[x][y][z+1] = dist+1;
			}
		}
		
		System.out.println(-1);
		return;
		
	}
	
	// 상하좌우앞뒤 체크하는 함수
	public static boolean check(int a, int  b, int c) {
		return (a>=0 && a<=M-1 && b>=0 && b<=N-1 && c>=0 && c<=H-1) ? true : false;
	}
}
