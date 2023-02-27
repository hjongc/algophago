package day0224;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2217_로프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] ropes = new int[sc.nextInt()];
		
		// 입력
		for (int i=0; i<ropes.length; i++) {
			ropes[i] = sc.nextInt();
		}
		
		// 오름차순 정렬
		Arrays.sort(ropes);
		
		int max = 0;
		for (int i=ropes.length-1; i>=0; i--) {
			int tmpMax = ropes[i] * (ropes.length-i); 
			if (tmpMax > max) max = tmpMax;
		}
		System.out.println(max);
	}
}
