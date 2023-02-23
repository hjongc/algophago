package DP;

import java.util.Scanner;

public class BOJ_10844_쉬운계단수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N 자릿수
		int N = sc.nextInt();
		
		// i자릿수 숫자 : 0으로 끝. 1로 끝... 9로 끝나는 계단수
		long[][] dp = new long[N + 1][10];
		
		// 1 자릿수
		for(int i = 0; i < 10; i++) {
			// 0은 계단수가 아니지만 나중에 처리
			dp[1][i] = 1;
		}
		
		if(N > 1) {
			// 각 자릿수 숫자 i으로 끝나는 오르막수
			// *숫자 i로 시작하는 수를 하면 0 해결이 어렵다
			
			for(int i = 2; i <= N; i++) {
				// 0으로 끝나는 수는 1에서
				// 1로 끝나는 수는 0, 2에서
				// 2로 끝나는 수는 1, 3에서
				// ...
				// 8로 끝나는 수는 7, 9에서
				// 9로 끝나는 수는 8에서

				dp[i][0] = dp[i - 1][1];
				for(int j = 1; j <= 8; j++) {
					// 두 자릿수 1로 끝나는 수는 2에서 끝나는 수만 온다
					if(i == 2 && j == 1) {
						dp[i][j] = dp[i - 1][2];
					} else {
						dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
					}
				}
				dp[i][9] = dp[i - 1][8];
				
			}
		}
		
		
		// N 자리수 0으로 끝나는 수 ~ 9로 끝나는 수 더하기
		long sum = 0;
		if(N == 1) {
			sum = 9; // 한자릿수는 0 제거
		} else {
			for(int j = 0; j < 10; j++) {
				sum += dp[N][j] % 1000000000;
			}
		}
		
		System.out.println(sum % 1000000000);
		
		
	}
}
