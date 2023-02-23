package DP;

import java.util.Scanner;

public class BOJ_11057_오르막수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N 자릿수
		int N = sc.nextInt();
		
		// i자릿수 숫자 : 0으로 시작. 1로 시작... 9로 시작하는 숫자 개수
		int[][] dp = new int[N + 1][10];
		
		// 1 자릿수
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		if(N > 1) {
			// 각 자릿수 숫자 i로 시작하는 오르막수
			for(int i = 2; i <= N; i++) {
				// 0 으로 시작하는 수는 없다
				// 1로 시작하는 수는 1 - 9의 합
				// 2로 시작하는 수는 2 - 9의 합
				// ...
				// 9로 시작하는 수는 9 - 9의 합
				
				for(int j = 1; j < 10; j++) {
					// 결국 j로 시작하는 수 개수는
					// dp[i - 1]의 j부터 9까지의 합이다
					for(int k = j; k < 10; k++) {
						dp[i][j] += dp[i - 1][k] % 10007;
					}
				}
			}
		}
		
		
		// 1자리부터 N자리까지 다!
		// 0으로 시작하는 수 ~ 9로 시작하는 수 더하기
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				sum += dp[i][j] % 10007;
			}
			// 더한 다음 모듈러를 안해줘서 10007 넘는 값이 결과로 나오고 있었는데
			// 왜 틀렸을까 하고 있었다니
			sum %= 10007;
		}
		
		System.out.println(sum);
		
	}
}
