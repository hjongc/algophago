package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// N개의 수
		int M = sc.nextInt();	// 차이가 M이상
		
		// 수열 받는 배열
		long[] arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		
		// 수열 정렬
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		
		// 시작 포인터, 끝 포인터
		int s = 0;
		int e = 0;
		
		// 차이가 M이상이면서 작은 차이
		// 시작은 제일 큰 차이로 둔다
		long min = arr[N - 1]- arr[0];
		

		// 맨 끝을 넘어가면 탈출
		while(e < N) {
			// 차이가 M보다 작다면 e가 커져야한다
			if(arr[e] - arr[s] < M) e++;

			// 차이가 M이면 탈출
			else if(arr[e] - arr[s] == M) {
				min = M;
				break;
			}
			
			// 차이가 M보다 크다면 
			else if(arr[e] - arr[s] > M) {
				// 그 안에서 최솟값 갱신되면 최신화
				if(arr[e] - arr[s] < min) {
					min = arr[e] - arr[s];
				}
				s++;
			}
		}
		
		System.out.println(min);
		
	}
}