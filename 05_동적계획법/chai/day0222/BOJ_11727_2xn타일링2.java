package day0222;

import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[1000+1];
		
		for (int i=1; i<=1000; i++) {
			if (i==1) dp[i] = 1; 
			else if (i==2) dp[i] = 3;
			else dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[n]%10007);
	}
}
