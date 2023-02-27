package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// RGB
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] R = new int[N+1];
		int[] G = new int[N+1];
		int[] B = new int[N+1];
		int[][] dp = new int[N+1][3];

		
		// row에는 N번째 집의 비용
		// col R, G, B
		//     0  1  2
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());	
		}
		
		// 첫번째 집  R[1], G[1], B[1]
		
		dp[1][0] = R[1];
		dp[1][1] = G[1];
		dp[1][2] = B[1];
		
		for (int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
		}
		int min = Math.min(dp[N][0], dp[N][1]);
		min = Math.min(min, dp[N][2]);
		
		System.out.println(min);
	}
}
