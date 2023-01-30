import java.util.Scanner;

public class BOJ_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[11+1];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int j = 4; j <= 11; j++) {
			if (dp[j] > 0) continue; 
			dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			
		}
	
		for (int i = 0; i < n; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	
	}
}
