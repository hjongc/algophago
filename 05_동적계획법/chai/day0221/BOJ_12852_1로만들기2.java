package day0221;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12852_1로만들기2 {
	public static void main(String[] args) {
		// DP로 최솟값을 구한 후 
		// 반대로 가면서 min값을 구한다.
		// min값을 덮어쓴다. => path 구할 수 있도
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		int[] path = new int[N+1];
		Arrays.fill(dp, 1000000);
		
		dp[1] = 0;
		
		for (int i=2; i<=N; i++) {
			if (i%3==0 && dp[i/3]+1 < dp[i]) {
				dp[i] = dp[i/3]+1;
				path[i] = i/3;
			}
			if (i%2==0 && dp[i/2]+1 < dp[i]) {
				dp[i] = dp[i/2]+1;
				path[i] = i/2;
			}
			if (dp[i-1]+1 < dp[i]) {
				dp[i] = dp[i-1]+1;
				path[i] = i-1;
			}
		}
		// 최솟값 출력 
		System.out.println(dp[N]);
		// 경로 출력 
		// path에는 이전에 어디에서 왔는지 저장되어있음 
		while (N>0) {
			System.out.print(N+" ");
			N = path[N];
		}

	}
}
