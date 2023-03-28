package day0328;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개의 자연수
		int N = sc.nextInt();
		// 부분수열의 합이 S인 경우
		int S = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 부분 수열의 합이 K인 경우의 수 
		int cnt = 0;

		// 4개의 원소가 있을 경우
		// 0부터 10000까지 있음 없음을 표현하는 숫자다 
		for(int i = 1; i < (1 << N); i++) {
			// 모든 부분집합 경우의 수에 대해서 K와 같은지 확인
			int sum = 0;
			
			// 0자릿수부터 N-1자리까지
			// 원소가 있는지 없는지 확인해서 더함
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					sum += arr[j];
				}
			}
			
			if(sum == S) {
				cnt++;
			}
		}
			
		System.out.println(cnt);
	}
}
