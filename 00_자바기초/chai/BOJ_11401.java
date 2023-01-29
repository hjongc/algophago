import java.util.Scanner;

public class BOJ_11401 {
	static long[][] dp;
	
	static long binomial(int n, int k) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		
		if (n == k || k == 0) {
			return dp[n][k] = 1;
		}
		
		return dp[n][k] = binomial(n-1, k-1)%1000000007 + binomial(n-1, k)%1000000007;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
	
		dp = new long[n+1][k+1];
		System.out.println(binomial(n,k)%1000000007);
	}
}
