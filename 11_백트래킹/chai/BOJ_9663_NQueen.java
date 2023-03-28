package day0323;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int N;
	static int cnt = 0;
	static boolean[] isUsed1;
	static boolean[] isUsed2;
	static boolean[] isUsed3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		isUsed1 = new boolean[N];
		isUsed2 = new boolean[2*N-1];
		isUsed3 = new boolean[2*N-1];
		
        nQueen(0);
        System.out.println(cnt);
	}

	private static void nQueen(int cur) {
		if (cur == N) {
			cnt++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			// isUsed1: 같은 행일 떄
			// isUsed2: 왼쪽 대각선일 때
			// isUsed3: 오른쪽 대각선일 때
			if (isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+N-1]) continue;
			
			isUsed1[i] = true;
			isUsed2[i+cur] = true;
			isUsed3[cur-i+N-1] = true;
			
			nQueen(cur+1);
			
			isUsed1[i] = false;
			isUsed2[i+cur] = false;
			isUsed3[cur-i+N-1] = false;
		}
	}
}