package DP;

import java.util.Scanner;

public class BOJ_14002_가장긴증가하는부분수열4 {
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
		// 전체 최댓값을 가진 인덱스 (인덱스를 알아야 log를 구한다)
		int maxIdx = 0;
		
		// 증가한 길이 저장 dp
		int[] dp = new int[N + 1];
		
		// 지나온 숫자 log
		String[] log = new String[N + 1];
		
		// 로그 가운데 띄어쓰기 때문에 초기값 따로 설정
		log[0] = "";
		
		
		for(int i = 1; i <= N; i++) {
			// dp 저장용 최댓값
			int dp_max = 0;
			int dp_max_idx = 0;
			
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					if(dp[j] > dp_max) {
						dp_max = dp[j];
						dp_max_idx = j;
					}
				}
			}
			
			// dp 최장길이랑 로그 입력
			// 틀린이유 0에서 이어질 때 앞에 띄어쓰기가 있어서
			dp[i] = dp_max + 1;
			log[i] = log[dp_max_idx] + arr[i] + " ";
			
			// 전체 최댓값 최신화
			if(dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}
			
		}
		
		System.out.println(max);
		System.out.println(log[maxIdx]);
		
	}
}
