package day0328;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15656_N과M7 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] used;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개의 자연수가 주어짐
		N = sc.nextInt();
		// N개의 자연수 중에서 M개를 고른 수열 (오름차순)
		M = sc.nextInt();

		// 숫자들 받고 오름차순 정렬
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		// 뽑았는지 확인 수열 - 인덱스
		used = new boolean[N];
		
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
		
		for(int i = 0; i <N; i++) {
			// 1번부터 N번 숫자까지
			// 사용하지 않았다면 ++ 오름차순
			if(!used[i] && nums[i] > arr[num]) {
				// 숫자 썼다고 체크하고
				used[i] = true;
				// 숫자 골랐다고 arr 입력하고
				arr[num + 1] = nums[i];
				// 다음 숫자도 고르러 가보자 (num번째 숫자를 i번로 고른 모든 경우)
				bt(num + 1);
				// 나왔다면 사용 안함으로 바꾸고 num번째 숫자로 뒷 숫자 넣어보기
				used[i] = false;
			}
		}
		
	}
}
