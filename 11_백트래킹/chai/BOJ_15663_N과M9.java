package day0327;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663_N과M9 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] sel, nums;
	static boolean[] isUsed;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		isUsed = new boolean[N];
		nums = new int[N];
		sel = new int[M];
		
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		func(0);
		System.out.println(sb);
	}

	private static void func(int d) {
		if (d == M) {
			for (int i=0; i<M; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		int tmp = 0;
		for (int i=0; i<N; i++) {
			if (!isUsed[i] && tmp != nums[i]) {
				isUsed[i] = true;
				sel[d] = nums[i];
				tmp = sel[d];
				func(d+1);
				isUsed[i] = false;
				
			}
		}
	}
}
