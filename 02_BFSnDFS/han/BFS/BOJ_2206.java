package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
	
	static boolean[][][] grid;
	static Queue<int[]> queue = new LinkedList<>();
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new boolean[N][M][3];
		
		for (int i = 0; i<N; i++) {
			String str = br.readLine();
			for (int j = 0; j<M; j++) {
				if (str.charAt(j) == '0') grid[i][j][0] = true;
			}
		}
		
		
		queue.offer(new int[] {0,0,1});
		grid[0][0][1] = true;
		grid[0][0][2] = true;
		
		
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			int x = out[0];
			int y = out[1];
			int dist = out[2];
			
			if (x == N-1 && y == M-1) {System.out.println(dist); return;}
			
			// 내가 벽을 넘지 않고 왔고
			if (grid[x][y][1]) {
				// 가려는 곳이 벽을 넘지 않고 갈 수 있고
				if (check(x-1, y) && grid[x-1][y][0]) {
					// 가본적 없는 곳이라면
					if (!grid[x-1][y][1]) {
						// 벽을 넘지 않고 방문
						queue.offer(new int[] {x-1,y,dist+1});
						grid[x-1][y][1] = true;
					}
					// 가려는 곳이 벽을 넘어야 하고
				} else if (check(x-1,y)) {
					// 벽을 한번 넘고서 가본적 없는 곳이라면
					if (!grid[x-1][y][2]) {
						// 벽을 넘으면서 방문
						queue.offer(new int[] {x-1,y,dist+1});
						grid[x-1][y][2] = true;
					}
				}
				if (check(x+1, y) && grid[x+1][y][0]) {
					if (!grid[x+1][y][1]) {
						queue.offer(new int[] {x+1,y,dist+1});
						grid[x+1][y][1] = true;
					}
				} else if (check(x+1,y)) {
					if (!grid[x+1][y][2]) {
						queue.offer(new int[] {x+1,y,dist+1});
						grid[x+1][y][2] = true;
					}
				}
				if (check(x, y-1) && grid[x][y-1][0]) {
					if (!grid[x][y-1][1]) {
						queue.offer(new int[] {x,y-1,dist+1});
						grid[x][y-1][1] = true;
					}
				} else if (check(x,y-1)) {
					if (!grid[x][y-1][2]) {
						queue.offer(new int[] {x,y-1,dist+1});
						grid[x][y-1][2] = true;
					}
				}
				if (check(x, y+1) && grid[x][y+1][0]) {
					if (!grid[x][y+1][1]) {
						queue.offer(new int[] {x,y+1,dist+1});
						grid[x][y+1][1] = true;
					}
				} else if (check(x,y+1)) {
					if (!grid[x][y+1][2]) {
						queue.offer(new int[] {x,y+1,dist+1});
						grid[x][y+1][2] = true;
					}
				}
			} 
			// 내가 벽을 넘고 왔고
			if (grid[x][y][2])  {
				// 가려는 곳이 벽을 넘지 않고 갈 수 있고 가본적 없다면
				if (check(x-1,y) && grid[x-1][y][0] && !grid[x-1][y][2]) {
					// 방문
					queue.offer(new int[] {x-1,y,dist+1});
					grid[x-1][y][2] = true;
				}
				if (check(x+1,y) && grid[x+1][y][0] && !grid[x+1][y][2]) {
					queue.offer(new int[] {x+1,y,dist+1});
					grid[x+1][y][2] = true;
				}
				if (check(x,y-1) && grid[x][y-1][0] && !grid[x][y-1][2]) {
					queue.offer(new int[] {x,y-1,dist+1});
					grid[x][y-1][2] = true;
				}
				if (check(x,y+1) && grid[x][y+1][0] && !grid[x][y+1][2]) {
					queue.offer(new int[] {x,y+1,dist+1});
					grid[x][y+1][2] = true;
				}
			}
		}
		System.out.println(-1);
		return;
		
	}
		
	public static boolean check(int x, int y) {
		return (x>=0 && x<=N-1 && y>=0 && y<=M-1);
	}
}
