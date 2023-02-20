import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] grid = new boolean[N][M];
		
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				if(br.read() == 49) grid[i][j] = true;  
			}
			br.readLine();
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {0, 0, 0});
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int X = tmp[0];
			int Y = tmp[1];
			int distance = tmp[2];
			
			if (X == N-1 && Y == M-1) {System.out.println(distance+1); return;}
			
			for (int i = 0; i<4; i++) {
				if (borderCheck(X + dx[i], Y + dy[i]) && grid[X + dx[i]][Y + dy[i]]){
					grid[X + dx[i]][Y + dy[i]] = false;
					queue.offer(new int[] {X + dx[i], Y + dy[i], distance+1});
				}
			}
		}
	}
	
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && x<N && y>=0 && y<M);
	}
}
