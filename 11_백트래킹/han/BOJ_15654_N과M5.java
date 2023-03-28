import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {
	public static StringBuffer sb = new StringBuffer();
	public static boolean[] isUsed;
	public static int[] input, numbers;
	public static int N, M;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[M];
		isUsed = new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		for (int i = 0; i<N; i++) {
			isUsed[i] = true;
			numbers[0] = input[i];
			backtrack(1);
			isUsed[i] = false;
		}
		
		System.out.print(sb);
	}
	public static void backtrack(int cnt) {
		if (cnt == M) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		else {
			for (int i = 0; i<N; i++) {
				if (!isUsed[i]) {
					isUsed[i] = true;
					numbers[cnt] = input[i];
					backtrack(cnt+1);
					isUsed[i] = false;
				}
			}
		}
	}
}