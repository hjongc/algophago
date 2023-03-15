package day0313;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1784_듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<String, Boolean> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String name = sc.next();
			
			map.put(name, false);
		}
		int cnt = 0;
		for (int i=0; i<M; i++) {
			String name = sc.next();
			
			if (map.containsKey(name)) {
				cnt++;
				map.replace(name, true);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		
		Object[] nameArr = map.keySet().toArray();
		Arrays.sort(nameArr);
		
		for (Object key: nameArr) {
			if (map.get(key)) sb.append(key).append("\n");
		}
		System.out.println(sb);
	}
}
