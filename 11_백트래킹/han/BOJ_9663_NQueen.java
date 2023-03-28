import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
	
	public static int N;
	public static boolean[] col;
	public static boolean[] dia1;
	public static boolean[] dia2;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		col = new boolean[N];
		dia1 = new boolean[2*N-1];
		dia2 = new boolean[2*N-1];
		
		queenCheck(0);
		System.out.println(ans);
		
	}
	
	public static void queenCheck(int row) {
		if (row == N) {
			ans++;
			return;
		}
		for (int i = 0; i<N; i++) {
			if (col[i] || dia1[i+row] || dia2[row+(N-1)-i]) continue;
			col[i] = true;
			dia1[i+row] = true;
			dia2[row+(N-1)-i] = true;
			queenCheck(row+1);
			col[i] = false;
			dia1[i+row] = false;
			dia2[row+(N-1)-i] = false;
		}
	}
}
