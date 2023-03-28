package day0328;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 7번이랑 11번 차이 : 4가 2번 들어올때 같은 수로 보나 다른 수로 보나 (2 4 / 2 4 4) 
// ArrayList가 있어야 중복 숫자를 안 받을 때 편하다
public class BOJ_15665_N과M11 {
	static int N;
	static int M;
	static int[] arr;
	static ArrayList<Integer> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개의 자연수가 주어짐
		N = sc.nextInt();
		// N개의 자연수 중에서 M개를 고른 수열 (중복가능)
		M = sc.nextInt();

		// 숫자를 받고 오름차순
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int in = sc.nextInt();
			if(!list.contains(in)) {
				list.add(in);
			}
		}
		// 숫자 오름차순 정렬
		Collections.sort(list);
		
		// 뽑은 자연수 넣는 수열
		arr = new int[M + 1];
		
		// 고른 숫자 0개
		bt(0);
		System.out.println(sb);
	}
	
	public static void bt(int num) {
		if(num == M) {
			for(int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		

		// list.get(i)에 숫자들이 들어있다
		for(int i = 0; i < list.size(); i++) {
			// 숫자 골랐다고 arr 입력하고
			arr[num + 1] = list.get(i);
			
			// 다음 숫자도 고르러 가보자 (num번째 숫자를 i번로 고른 모든 경우)
			bt(num + 1);
		}
		
	}
}
