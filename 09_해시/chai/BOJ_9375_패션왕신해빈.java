package day0310;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t=0; t<T; t++) {
			int N = sc.nextInt();
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i=0; i<N; i++) {
				String x = sc.next();
				String part = sc.next();
				
				if (map.containsKey(part)) map.replace(part, map.get(part)+1);
				else map.put(part, 1);
			}
			
			// 파트별로 하나씩 뽑아봄
			int cnt = 1; // 6 
			
			// (모자+1) * (상의+1) * (하의+1) - 1
			// +1하는 이유는 아예 안 입은 경우 
			// -1하는 이유는 모두 벗었을 때 
			for (String k: map.keySet()) {
				cnt *= map.get(k)+1;
			}
			sb.append(cnt-1).append("\n");
		}
		System.out.println(sb);
	}
}
