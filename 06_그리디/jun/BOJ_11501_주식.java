package 그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_11501_주식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			
			// 날 수 N
			int N = sc.nextInt();
			int[] stock = new int[N];
			for(int i = 0; i < N; i++) {
				stock[i] = sc.nextInt();
			}
			
			
			// 최댓값 찾는다 -> 앞 인덱스 값과의 차이가 이익이다 -> 누적합을 구한다
			// 그 다음 최댓값을 찾으며 반복한다
			
			// 이걸! 뒤에서부터 max를 하면 된다
			// 답 21억 넘어가는 테스트케이스있음 long 형으로 선언해야함
			long rev = 0;
			int max = stock[N - 1];
			
			for(int i = N - 1; i >= 0; i--) {
				// 뒤에서부터 최댓값을 갱신하면 최댓값 최신화
				// 이때는 사고팔지 않는다
				if(stock[i] > max) {
					max = stock[i];
					
					// 뒤에 있는 최댓값보다 작으면
					// 이때 사서 최댓값에 판다
				} else {
					rev += max - stock[i];
				}
			}
			
			System.out.println(rev);
		}
		
	}
}

// Collections.sort() 시간복잡도 nlogn
// log10^6 = 6... 아 당연한 거네
//	class Stock implements Comparable<Stock> {
//		int idx;
//		int val;
//		
//		public Stock(int idx, int val) {
//			this.idx = idx;
//			this.val = val;
//		}
//
//		@Override
//		public int compareTo(Stock o) {
//			return o.val - this.val;
//		}
//	}
