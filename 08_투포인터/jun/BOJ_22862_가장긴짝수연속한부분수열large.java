package 투포인터;

import java.util.Scanner;

public class BOJ_22862_가장긴짝수연속한부분수열large {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 수열의 길이 N
		int k = sc.nextInt();	// 삭제할 수 있는 최대 횟수

		// 연속된 짝수 길이는 양수로 넣는다
		// 연속된 홀수 길이는 음수로 넣는다
		// K번 원소를 삭제할 수 있으면 짝수개수를 K+1개 고를 수 있다
		// 홀수인지 짝수인지

		boolean[] even = new boolean[N];

		for(int i = 0; i < N; i++) {
			int in = sc.nextInt();
			if(in % 2 == 0) even[i] = true;
		}


		// 확인해야할 반례 : 짝수가 하나도 없을 때, 짝수 하나일 때 확인해야 한다
		// 3 0 : 1 1 1 (답이 0)
		// 1 1 : 2 (답이 1)
		
		// 시작점 끝점 길이 최대길이
		int s = 0;
		int e = 0;
		int len = 0;
		int max = 0;

		// 나아가기 전에 처음 확인 시작
		// 짝수면 길이 늘림
		if(even[e]) {
			len++;
			// 최댓값  최신화
			if(len > max) max = len;
		
		// 홀수면 K에서 빼고 감소
		} else {
			k--;
		} // 확인 끝
		
		
		while(e < N) {
			// K가 남아있다면 나아감
			if(k >= 0) {
				// e는 증가시키되 범위 벗어나면 break
				e++;
				if(e == N) break;
				
				// 짝수면 길이 늘림
				if(even[e]) {
					len++;
					// 최댓값  최신화
					if(len > max) max = len;
				
				// 홀수면 K에서 빼고 감소
				} else {
					k--;
				}
	
			// K가 음수면 안된다
			} else {
				// 시작점이 짝수면 길이 감소
				// 홀수면 K증가시킴
				if(even[s]) {
					len--;
				} else {
					k++;
				}
				
				// 처리했으니 인덱스 증가시킴
				s++;
			}
//			System.out.println(s + " " + e);
//			System.out.println("len : " + len);
//			System.out.println("k : " + k);
		}
	
		System.out.println(max);
	}
}