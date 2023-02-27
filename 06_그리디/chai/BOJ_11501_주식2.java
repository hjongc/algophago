package day0226;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_11501_주식2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=0; t<T; t++) {
			int N = sc.nextInt(); // 자연수 갯수
			int[] prices = new int[N]; // 주식가격담을 배열
			for (int i=0; i<N; i++) {
				prices[i] = sc.nextInt();
			}
			
			// 뒤에서부터 주식가격을 확인한다.
			// 기준가격보다 작은 값이 나오면 주식을 산다.
			// 기준가격보다 큰 가격이 나오면 스택에 담겨있는 값을 현재 기준가격기준으로 판다.
			// 그리고 큰 가격이 기준가격이 된다.
			long sum = 0;
			long max = 0; 
			for (int i=N-1; i>=0; i--) { // 기준인덱스
				if (prices[i] > max) max = prices[i];
				else {
					sum += max-prices[i];
				}
			}
			System.out.println(sum);
		}
	}
}
