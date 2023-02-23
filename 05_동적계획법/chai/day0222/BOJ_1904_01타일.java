package day0222;

import java.util.Scanner;

public class BOJ_1904_01타일 {
	public static void main(String[] args) {
		// 하나씩 계산해보니
		// 피보나치 수열과 같다.
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		for (int i=1; i<=N; i++) {
			if (i<=2) dp[i] = i;
			
			else dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		System.out.println(dp[N]%15746);
	}
}
