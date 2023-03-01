package day0224;

import java.util.Scanner;

public class BOJ_11047_동전0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 입력을 배열에 넣어준다.
		int[] coins = new int[N];
		for (int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		
		// 내림차순으로 순회하면서
		// 동전을 세어본다.
		int cnt = 0;
		for (int i=N-1; i>=0; i--) {
			if (coins[i]>K) continue;
			 int tmpCnt = K / coins[i];
			 cnt += tmpCnt;
			 K -= coins[i] * tmpCnt;
		}
		System.out.println(cnt);
	}
}
