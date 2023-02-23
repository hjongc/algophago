import java.util.Scanner;

public class BOJ_11050_3 {
	static int[][] dp;
	
	static int binomial(int n, int k) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		
		if (n == k || k == 0) {
			return dp[n][k] = 1;
		}
		
		return dp[n][k] = binomial(n-1, k-1) + binomial(n-1, k);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
	
		dp = new int[n+1][k+1];
		System.out.println();
	}
}
