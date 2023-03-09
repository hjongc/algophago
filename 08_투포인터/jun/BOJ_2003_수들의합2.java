package 투포인터;

import java.util.Scanner;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// N개의 수
		int M = sc.nextInt();	// i번째부터 j번째까지 수의 합 M
		
		// N개의 수 누적합 배열
		long[] sum = new long[N + 1];
		long temp = 0;
		for(int i = 1; i <= N; i++) {
			temp += sc.nextInt();
			sum[i] = temp;
		}
		
		// 시작점 끝점
		int s = 0;
		int e = 0;
		
		// 개수 세기
		int cnt = 0;
		
		while(e > N) {
			
			// M보다 작으면 끝점 키우기
			if(sum[e] - sum[s - 1] < M) e++;
			
			// 끝점이 범위를 탈출하면 break
			if(e > N) break;
			
			// M이랑 똑같으면 cnt 증가하고 시작점 증가
			if(sum[e] - sum[s - 1] == M) {
				cnt++;
				s++;
			}
			
			// M보다 크면 시작점 증가
			if(sum[e] - sum[s - 1] > M) {
				s++;
			}			
		}
		
		System.out.println(cnt);
		
	}
}
