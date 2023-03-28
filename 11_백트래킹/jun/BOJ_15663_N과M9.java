package day0328;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_15663_N과M9 {
	static int N;
	static int M;
	static int[] arr;
	static HashMap<Integer, Integer> hm;
	static ArrayList<Integer> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개의 자연수가 주어짐
		N = sc.nextInt();
		// N개의 자연수 중에서 M개를 고른 수열
		M = sc.nextInt();

		// 숫자들 받고 오름차순 정렬
		hm = new HashMap<>();
		// 무슨 숫자가 있는지
		list = new ArrayList<>();
		// 각 숫자가 몇 개 있는지
		for(int i = 0; i < N; i++) {
			int in = sc.nextInt();
			
			// 해시맵에 숫자가 이미 있다면 증가
			if(hm.containsKey(in)) {
				hm.put(in, hm.get(in) + 1);
			// 해시맵에 숫자가 없다면 1개 추가
			} else {
				hm.put(in, 1);
			}
			
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
			// 사용하지 않아서 해시맵에 숫자가 있다면
			if(hm.get(list.get(i)) > 0) {
				// 숫자 골랐다고 arr 입력하고
				arr[num + 1] = list.get(i);
				
				// 사용했으니까 해시맵에서 숫자 감소
				hm.put(list.get(i), hm.get(list.get(i)) - 1);
				
				// 다음 숫자도 고르러 가보자 (num번째 숫자를 i번로 고른 모든 경우)
				bt(num + 1);
				
				// 고르고 왔으면 숫자 다시 추가
				hm.put(list.get(i), hm.get(list.get(i)) + 1);
			}
		}
		
	}
}
