import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1799_비숍 {
	public static int N, maxwhite, maxblack;
	public static boolean[][] board;
	public static boolean[] diagonal_left, diagonal_right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new boolean[N][N];
		
		diagonal_left = new boolean[2*N-1];
		diagonal_right = new boolean[2*N-1];
		
		int bishopcnt = 0;
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					board[i][j] = true;
					bishopcnt++;
				}
			}
		}
		if (bishopcnt == 0) {
			System.out.println("0");
			return;
		}
		
		maxwhite = 0;
		maxblack = 0;
		
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if ((i+j)%2 == 0 && board[i][j]) {
					board[i][j] = false;
					diagonal_left[N-1-i+j] = true;
					diagonal_right[2*N-2-i-j] = true;
					bishopwhite(i, j, 1);
					board[i][j] = true;
					diagonal_left[N-1-i+j] = false;
					diagonal_right[2*N-2-i-j] = false;
					
				} else if (board[i][j]) {
					board[i][j] = false;
					diagonal_left[N-1-i+j] = true;
					diagonal_right[2*N-2-i-j] = true;
					bishopblack(i, j, 1);
					board[i][j] = true;
					diagonal_left[N-1-i+j] = false;
					diagonal_right[2*N-2-i-j] = false;
				}
			}
		}
		System.out.println(maxwhite+maxblack);
	}
	public static void bishopwhite(int x, int y, int cnt) {
		if (cnt > maxwhite) maxwhite = cnt;
		for (int i = y+1; i<N; i++) {
			if ((x+i)%2 == 0 && board[x][i] && !diagonal_left[N-1-x+i] && !diagonal_right[2*N-2-x-i]) {
				board[x][i] = false;
				diagonal_left[N-1-x+i] = true;
				diagonal_right[2*N-2-x-i] = true;
				bishopwhite(x, i, cnt+1);
				board[x][i] = true;
				diagonal_left[N-1-x+i] = false;
				diagonal_right[2*N-2-x-i] = false;
			}
		}
		for (int i = x+1; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if ((i+j)%2 == 0 && board[i][j] && !diagonal_left[N-1-i+j] && !diagonal_right[2*N-2-i-j]) {
					board[i][j] = false;
					diagonal_left[N-1-i+j] = true;
					diagonal_right[2*N-2-i-j] = true;
					bishopwhite(i, j, cnt+1);
					board[i][j] = true;
					diagonal_left[N-1-i+j] = false;
					diagonal_right[2*N-2-i-j] = false;
					
				}
			}
		}
	}
	public static void bishopblack(int x, int y, int cnt) {
		if (cnt > maxblack) maxblack = cnt;
		for (int i = y+1; i<N; i++) {
			if ((x+i)%2 == 1 && board[x][i] && !diagonal_left[N-1-x+i] && !diagonal_right[2*N-2-x-i]) {
				board[x][i] = false;
				diagonal_left[N-1-x+i] = true;
				diagonal_right[2*N-2-x-i] = true;
				bishopblack(x, i, cnt+1);
				board[x][i] = true;
				diagonal_left[N-1-x+i] = false;
				diagonal_right[2*N-2-x-i] = false;
			}
		}
		for (int i = x+1; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if ((i+j)%2 == 1 && board[i][j] && !diagonal_left[N-1-i+j] && !diagonal_right[2*N-2-i-j]) {
					board[i][j] = false;
					diagonal_left[N-1-i+j] = true;
					diagonal_right[2*N-2-i-j] = true;
					bishopblack(i, j, cnt+1);
					board[i][j] = true;
					diagonal_left[N-1-i+j] = false;
					diagonal_right[2*N-2-i-j] = false;
					
				}
			}
		}
	}
}
