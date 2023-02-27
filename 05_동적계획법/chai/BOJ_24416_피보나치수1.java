package day0222;

import java.util.Scanner;

public class BOJ_24416_피보나치수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		fibo1(N);
		fibo2(N);
		
		System.out.printf("%d %d\n",cnt1,cnt2);
		
	}
	
	// 재귀 이용
	static int cnt1 = 0;
	static int fibo1(int n) {
		
		if (n<=2) {
			cnt1++;
			return 1;
		}
		else return fibo1(n-1) + fibo1(n-2);
	}
	// dp 이용
	static int cnt2 = 0;
	static int fibo2(int n) {
		int[] arr = new int[n+1];
		if (n<=2) arr[n] = 1;
		for (int i=3; i<=n; i++) {
			cnt2++;
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
	
}
