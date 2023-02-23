package DP;

import java.util.Scanner;

public class BOJ_12852_1로만들기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		// 초기값 출력
		if(N == 1) {System.out.println("0\n1"); }
		if(N == 2) {System.out.println("1\n2 1");}
		if(N == 3) {System.out.println("1\n 3 1");}
		

		if(N >= 4) {
			// 최소값 저장
			int[] seq = new int[N + 1];
			seq[1] = 0;
			seq[2] = 1;
			seq[3] = 1;
			
			// 로그 저장
			String[] log = new String[N + 1];
			log[1] = "1";
			log[2] = "2 1";
			log[3] = "3 1";
			
			for(int i = 4; i <= N; i++) {
				// 빼기1 나누기2 나누기3 [값은 뭔지] 
				int[] arr = new int[3];
				
				// 직전에서 온 값 저장
				arr[0] = seq[i-1] + 1;
				if(i % 2 == 0) { arr[1] = seq[i/2] + 1; }
				if(i % 3 == 0) { arr[2] = seq[i/3] + 1; }
				
				// 이 중 최소값 구하기
				int min = arr[0];
				if(arr[1] != 0 && arr[1] < min) min = arr[1];
				if(arr[2] != 0 && arr[2] < min) min = arr[2];
				seq[i] = min;
				
				// 최소값을 보이는 숫자 반환해서 로그 저장
				if(min == arr[0]) log[i] = i + " " + log[i - 1];
				if(min == arr[1]) log[i] = i + " " + log[i / 2];
				if(min == arr[2]) log[i] = i + " " + log[i / 3];
				
			}
			
			System.out.println(seq[N]);
			System.out.println(log[N]);
			
		}
	}
}