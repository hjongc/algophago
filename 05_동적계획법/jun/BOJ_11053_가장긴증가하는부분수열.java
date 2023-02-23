package DP;

import java.util.Scanner;

public class BOJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		// 인덱스 0에 제일 작은 수 0을 놓기 위해서
		// 입력값은 1부터 시작한다
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 전체 최댓값
		int max = 0;
		
		// 증가한 길이 저장 dp
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			
			// dp 저장용 최댓값
			int dp_max = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					if(dp[j] > dp_max) dp_max = dp[j];
				}
			}
			dp[i] = dp_max + 1;
			
			// 전체 최댓값 최신화
			if(dp[i] > max) max = dp[i];
			
		}
		
		System.out.println(max);
		
	}
}
