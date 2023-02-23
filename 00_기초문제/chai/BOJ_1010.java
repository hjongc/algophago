import java.util.Scanner;

public class BOJ_1010 {
	
	static int[][] dp = new int[30][30];
	 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			int n = sc.nextInt();	// N = r
			int m = sc.nextInt();	// M = n
			
			System.out.println(combination(m,n));
		}		
	}
	
	static int combination(int n, int m) {
		if (dp[n][m] != 0) {
			return dp[n][m];
		}
		
		if (m==n || m==0) {
			return dp[n][m]=1;
		}
		
		return dp[n][m]= combination(n-1,m-1)+combination(n-1, m); 
		
	}
	
}
