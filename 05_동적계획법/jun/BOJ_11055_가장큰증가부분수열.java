package DP;

import java.util.Scanner;

public class BOJ_11055_가장큰증가부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		// 제로인덱스X
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 해당 자리까지의 증가 부분 수열
		int[] dp = new int[N + 1];
		
		// 전체 최댓값
		int max = 0;
		
		// 초기값
		// dp[0]과 arr[0]은 기본값 0으로 초기화되어 있다
		// 작은 숫자를 찾으려 내려오면 0에서 무조건 걸린다
		for(int i = 1; i <= N; i++) {

			// 되돌아가서 작은 숫자 찾는다.
			// 그 중에서 제일 큰거에 연결한다.
			// i보다 작은 수 중에서 최댓값
			int max2 = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					if(dp[j] > max2) max2 = dp[j];
				}
			}
			dp[i] = max2 + arr[i];
			
			// 전체 최댓값 최신화
			if(dp[i] > max) max = dp[i];
		}
		
		// 확인용 출력
//		for(int i = 1; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
		
		System.out.println(max);
		
	}
}
