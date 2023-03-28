package day0326;

import java.util.Scanner;

public class BOJ_15650_N과M2 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] sel;
	static boolean[] isUsed;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		isUsed = new boolean[N+1];
		sel = new int[M];
		
		func(0);
		System.out.println(sb);
	}

	private static void func(int d) {
		if (d == M) {
			for (int i=0; i<M; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
//			System.out.println(sb);
			return;
		}
		
		int st = 1;
		if (d != 0) st = sel[d-1];
		
		for (int i=st; i<=N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				sel[d] = i;
				func(d+1);
				isUsed[i] = false;
			}
		}
	}
}
