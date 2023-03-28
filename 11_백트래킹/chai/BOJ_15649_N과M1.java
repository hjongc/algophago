package day0326;

import java.util.Scanner;

public class BOJ_15649_N과M1 {
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

	private static void func(int depth) {
		if (depth == M) {
			for (int i=0; i<M; i++) {
				sb.append(sel[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (!isUsed[i]) {
				sel[depth] = i;
				isUsed[i] = true;
				func(depth+1);
				isUsed[i] = false;
			}
		}
	}
}
