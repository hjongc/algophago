import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 계단 수
		int[] stairs = new int[n+1];
		int[] dp = new int[n+2];
		
		// 각 계단의 값 배열에 저장 
		for (int i = 1; i <= n; i++) {
			stairs[i] = sc.nextInt();
		}
		
		dp[1] = stairs[1];
		
		
		for (int i = 2; i <= n; i++) {
			if (i==2) dp[2] = stairs[1]+stairs[2];
			else if (i==3) dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
			else dp[i] = Math.max(dp[i-3]+stairs[i-1], dp[i-2]) + stairs[i];
		}

		System.out.println(dp[n]);
	}
}
