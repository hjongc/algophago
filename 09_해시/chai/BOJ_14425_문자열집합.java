package day0314;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_14425_문자열집합 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<String> set = new HashSet<String>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			set.add(sc.next());
		}
		
		int cnt = 0;
		for (int i=0; i<M; i++) {
			String test = sc.next();
			
			if (set.contains(test)) cnt++;
		}
		System.out.println(cnt);
	}
}
