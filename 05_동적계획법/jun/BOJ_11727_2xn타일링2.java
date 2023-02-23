package DP;

import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		// 전에서 (세로 한 개) 더한 거
		// 전전에서 (가로 두 개 / 덩어리 한 개) 2가지로 나뉨
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		
		System.out.println(dp[n]);
		
	}
}
