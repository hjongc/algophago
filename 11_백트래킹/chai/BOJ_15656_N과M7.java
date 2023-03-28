package day0326;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15656_N과M7 {
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
		
		func(0, 0);
		System.out.println(sb);
	}

	private static void func(int d, int cur) {
		if (d == M) {
			for (int i=0; i<M; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i=0; i<N; i++) {
				sel[d] = nums[i];
				func(d+1, i);
		}
	}
}
