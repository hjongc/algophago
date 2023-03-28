import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {
	public static StringBuffer sb = new StringBuffer();
	public static boolean[] isUsed;
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isUsed = new boolean[N];
		
		for (int i = 0; i<N; i++) {
			isUsed[i] = true;
			backtrack(i, 1);
			isUsed[i] = false;
		}
		
		System.out.print(sb);
	}
	public static void backtrack(int in, int cnt) {
		if (cnt == M) {
			for (int i = 0; i<N; i++) {
				if(isUsed[i]) sb.append(i+1).append(" ");
			}
			sb.append("\n");
		}
		else {
			for (int i = in+1; i<N; i++) {
				if (isUsed[i]) continue;
				else {
					isUsed[i] = true;
					backtrack(i, cnt+1);
					isUsed[i] = false;
				}
			}
		}
		
	}
}
