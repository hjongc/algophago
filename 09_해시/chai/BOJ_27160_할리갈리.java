package day0307;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_27160_할리갈리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String s = sc.next();
			int num = sc.nextInt();
			
			if (map.containsKey(s)) {
				
				map.put(s, map.get(s)+num);
			}
			else map.put(s, num);
		}
		
		for (String s: map.keySet()) {
			if (map.get(s) == 5) {
				System.out.println("YES");  
				return;
			}
		}
		
		System.out.println("NO");  
	}
}
