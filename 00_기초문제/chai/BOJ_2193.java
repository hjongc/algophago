import java.util.Scanner;

public class BOJ_2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+2];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
