import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {
	public static StringBuffer sb = new StringBuffer();
	public static int[] used;
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		used = new int[M];
		
		for (int i = 0; i<N; i++) {
			used[0] = i;
			backtrack(1);
		}
		
		System.out.print(sb);
	}
	public static void backtrack(int cnt) {
		if (cnt == M) {
			for (int i : used) {
				sb.append(i+1).append(" ");
			}
			sb.append("\n");
		}
		else {
			for (int i = 0; i<N; i++) {
				used[cnt] = i;
				backtrack(cnt+1);
			}
		}
	}
}
