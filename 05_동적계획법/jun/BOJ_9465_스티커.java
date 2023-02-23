package DP;

import java.util.Scanner;

public class BOJ_9465_스티커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스
		int T = sc.nextInt();
		for(int t = 0; t < T; t++ ) {
			int n = sc.nextInt();
			
			// 스티커 점수 입력
			// 0은 패딩으로 두고 1열 ~ n열 (제로인덱스X)
			int[][] arr = new int[3][n + 1];
			for(int i = 1; i <= 2; i++) {
				for(int j = 1; j <= n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 1행 스티커, 2행 스티커, 안 선택 했을 때 최댓값 저장
			int[][] dp = new int[3][n + 1];
			for(int i = 1; i <= n; i++) {
				// 1행 <- 2행이랑 안 선택 중에서 최댓값
				dp[1][i] = Math.max(dp[2][i - 1], dp[0][i - 1]) + arr[1][i];
				
				// 2행 <- 1행이랑 안 선택 중에서 최댓값
				dp[2][i] = Math.max(dp[1][i - 1], dp[0][i - 1]) + arr[2][i];
				
				// 안 선택 <- 1행이랑 2행 안선택 중에서 최댓값
				dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
			}
			
			// 셋 중에서 최댓값
			System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
			
		}
	}
}
