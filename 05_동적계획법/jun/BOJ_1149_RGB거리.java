package DP;
import java.util.Scanner;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		// 2차원 배열 3열에 <빨강 초록 파랑> 칠했을 때의 비용 저장
		int[][] dp = new int[N][3];
		dp[0][0] = sc.nextInt();
		dp[0][1] = sc.nextInt();
		dp[0][2] = sc.nextInt();
		
		for(int i = 1; i < N; i++) {
			// DP 다른색에서 오는 최소비용 저장
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + sc.nextInt();
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + sc.nextInt();
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + sc.nextInt();
		}
		System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
		
		
	}	
}
