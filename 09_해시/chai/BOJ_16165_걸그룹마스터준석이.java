package day0310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_16165_걸그룹마스터준석이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<String, String[]> map1 = new HashMap<String, String[]>();
		Map<String, String> map2 = new HashMap<String, String>();
		for (int n=0; n<N; n++) {
			String gn = sc.next(); // group name 
			int nums = sc.nextInt(); // 그룹인원 

			// 맵을 두개를 만든다.
			// map<그룹이름, 멤버이름[]>
			// map<멤버이름, 그룹이름>
			String[] group = new String[nums];
			for (int num=0; num<nums; num++) {
				String mn = sc.next(); // member name
				group[num] = mn;
				map2.put(mn, gn);
			}
			Arrays.sort(group);
			map1.put(gn, group);
		}
		// 퀴즈를 맞춘다.
		// 0이 들어오면 해당 그룹 내 멤버이름을 모두 말한다.
		// 1이 들어오면 그룹 명만 찾는다.
		StringBuilder sb = new StringBuilder(); 
		for (int m=0; m<M; m++) {
			String q = sc.next(); // question
			int cmd = sc.nextInt();
			
			if (cmd == 0) {
				String[] arr = map1.get(q);
				for (int i=0; i<arr.length; i++) {
					sb.append(arr[i]).append("\n");
				}
			}else {
				sb.append(map2.get(q)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
