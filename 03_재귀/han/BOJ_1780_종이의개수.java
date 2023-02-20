import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	
	public static int oneCnt, zeroCnt, minusCnt;
	public static int[][] grid;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		grid = new int[size][size];
		
		for (int i = 0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<size; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		oneCnt = 0;
		zeroCnt = 0;
		minusCnt = 0;
		paperFind(size, 0, 0);
		
		System.out.println(minusCnt);
		System.out.println(zeroCnt);
		System.out.println(oneCnt);
	}
	
	public static void paperFind(int size, int x, int y) {
		int tmp = grid[x][y];
		if (size == 1) {
			if (tmp == 0) zeroCnt ++;
			else if (tmp == 1) oneCnt ++;
			else minusCnt ++;
			return;
		}
		
		for (int i = x; i<x+size; i++) {
			for (int j = y; j<y+size; j++) {
				if (grid[i][j] != tmp) {
					paperFind(size/3, x, y);
					paperFind(size/3, x, y+size/3);
					paperFind(size/3, x, y+size*2/3);
					paperFind(size/3, x+size/3, y);
					paperFind(size/3, x+size/3, y+size/3);
					paperFind(size/3, x+size/3, y+size*2/3);
					paperFind(size/3, x+size*2/3, y);
					paperFind(size/3, x+size*2/3, y+size/3);
					paperFind(size/3, x+size*2/3, y+size*2/3);
					return;
				}
			}
		}
		
		if (tmp == 0) zeroCnt ++;
		else if (tmp == 1) oneCnt ++;
		else minusCnt ++;
		return;
	}
}
