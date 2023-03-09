package 투포인터;

import java.util.Scanner;

public class BOJ_1806_부분합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 수열 길이 N
		int S = sc.nextInt();	// 연속된 수 들의 부분합 중에 S이상인 것 중 짧은 수열
		
		
		// 수열 누적합으로 입력 (0은 비워두고 1 ~ N)
		int[] sum = new int[N + 1];
		int temp = 0;
		for(int i = 1; i <= N; i++) {
			temp += sc.nextInt();
			sum[i] = temp;
		}
		
		// 시작점과 끝점s
		int s = 1;
		int e = 1;
		
		// 길이 min
		int min = N - 1; 
		boolean find = false;
		
		while(e <= N) {
			// 합이 S보다 작으면 끝점을 키운다
			if(sum[e] - sum[s - 1] < S) {
				e++;
			}
			
			// 끝점이 맨 끝을 넘어가면 탈출
			if(e > N) break;
			
			// 합이 S이상이면 
			if(sum[e] - sum[s - 1] >= S) {
				// 길이 최신화를 하고
				if(e - s < min) min = e - s;
				// 시작점을 당긴다
				s++;
				// 합 찾았다고 표시
				find = true;
			}
		}
		
		// 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
		if(!find) {
			System.out.println(0);
		} else {
			System.out.println(min + 1);
		}
		
	}
}
