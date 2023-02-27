package day0226;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_11501_주식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=0; t<T; t++) {
			int N = sc.nextInt(); // 자연수 갯수
			long[] prices = new long[N]; // 주식가격담을 배열
			for (int i=0; i<N; i++) {
				prices[i] = sc.nextInt();
			}
			
			// 뒤에서부터 주식가격을 확인한다.
			// 기준가격보다 작은 값이 나오면 주식을 산다.
			// 기준가격보다 큰 가격이 나오면 스택에 담겨있는 값을 현재 기준가격기준으로 판다.
			// 그리고 큰 가격이 기준가격이 된다.
			long sum = 0;
			long curPrice = prices[N-1];
			Stack<Long> stack = new Stack<>();
			boolean isEnd = false;
			for (int i=prices.length-1; i>0; i--) { // 기준인덱스
				
				if (isEnd) break;
				for (int j=i-1; j>=0; j--) { // 비교인덱스
//					System.out.printf("%d %d\n", j, i);
					if (prices[j] < prices[i]) {
						stack.push(prices[j]);
//						System.out.println(111);
					}
					else { // prices[j] >= prices[i]
//						System.out.println(222);
						while (!stack.isEmpty()) {
							sum += curPrice - stack.pop();
							
						}
						curPrice = prices[j];
					}
					if (j==0) isEnd = true;
					
				}
				
			}
//			System.out.println(stack.isEmpty());
			while (!stack.isEmpty()) {
				sum += curPrice - stack.pop();
			}
			System.out.println(sum);
		}
	}
}
