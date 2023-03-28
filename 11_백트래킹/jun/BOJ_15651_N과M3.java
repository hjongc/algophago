package day0328;

import java.util.Scanner;

public class BOJ_15651_N과M3 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1부터 N까지 자연수 중에서
		N = sc.nextInt();
		// 중복 없이 M개를 고른 수열
		// 같은 수를 여러번 골라도 된다
		M = sc.nextInt();

		// 뽑은 자연수 넣는 수열
		arr = new int[M + 1];
		
		// 고른 숫자 0개
		bt(0);
		
		System.out.println(sb);
	}
	
	public static void bt(int num) {
		if(num == M) {

			for(int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <=N; i++) {
			// 1부터 N까지
			// 숫자 골랐다고 arr 입력하고
			arr[num + 1] = i;
			// 다음 숫자도 고르러 가보자 (num번째 숫자를 i로 고른 모든 경우)
			bt(num + 1);
		}
		
	}
}
