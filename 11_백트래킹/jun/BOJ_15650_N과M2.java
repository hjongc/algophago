package day0328;

import java.util.Scanner;

public class BOJ_15650_N과M2 {
	static int N;
	static int M;
	static boolean[] used;
	static int[] arr;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1부터 N까지 자연수 중에서
		N = sc.nextInt();
		// 중복 없이 M개를 고른 수열 (1 ≤ M ≤ N ≤ 8)(오름차순)
		M = sc.nextInt();
		// 자연수가 사용되었는지 확인
		used = new boolean[N + 1];

		// 뽑은 자연수 넣는 수열
		arr = new int[M + 1];
		// 고른 숫자 0개
		bt(0);
	}
	
	public static void bt(int num) {
		if(num == M) {

			for(int i = 1; i <= M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <=N; i++) {
			// 1부터 N까지
			// 숫자를 쓰지 않았다면 
			// ******* 직전 고른 숫자보다 크다면 ****** 추가
			if(!used[i] && i > arr[num]) {
				// i로 숫자를 고르고
				used[i] = true;
				// 숫자 골랐다고 arr 입력하고
				arr[num + 1] = i;
				// 다음 숫자도 고르러 가보자 (num번째 숫자를 i로 고른 모든 경우)
				bt(num + 1);
				// 고르고 왔으면 다시 고르기
				used[i] = false;
			}
		}
		
	}
}
