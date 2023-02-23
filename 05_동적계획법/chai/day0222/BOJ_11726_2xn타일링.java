package day0222;

import java.util.Scanner;

public class BOJ_11726_2xn타일링 {
	public static void main(String[] args) {
		// dp[k] = dp[k-1] + dp[k-2]
		// 만약 첫 번째 칸을 2*1(세로) 로 채운다고 하자
		// 그렇다면 남은 칸은 2*(k-1)일 것이다.
		// 2*(k-1)을 채우는 경우의 수는 dp[k-1]이다.
		
		// 만약 첫 번째 칸을 1*2(가로)로 채운다고 하자.
		// 그렇다면 바로 밑 가로로 된 칸이 생기는 데 이 부분도 
		// 1*2 타일로 채울 수밖에 없다.
		// 위 아래로 1*2타일로 채운다면 2*(k-2)가 남는다.
		// 이를 채우는 경우의 수는 dp[k-2]에 저장되어 있다.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			if (i==1) dp[i] = 1;
			else if (i==2) dp[i] = 2;
			else dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[n]%10007);
	}
}	
