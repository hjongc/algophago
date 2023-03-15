package day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_13414_수강신청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=1; i<=L; i++) {
			String sn = br.readLine(); // Student Number
			
			// 이미 맵에 존재한다면?
			// value값을 현재시점으로 늘려준다
			// 처음 나온 학번이라면 추가해준다.
			// 조건 나누지말고 그냥 put하면 덮어써진다.
			map.put(sn,i);
		}
		// map value가 곧 순서이다.
		// value를 인덱스로 하고 해당 인덱스에 map key 즉 학번을 넣는다.
		String[] arr = new String[L+1];
		for (String key: map.keySet()) {
			int idx = map.get(key);
			
			arr[idx] = key; 
		}
		
		// 위에서 값이 들어가지 않은 인덱스에는
		// null값이 들어가있다.
		// null일 때는 건너뛰고
		// K개를 모두 확인했다면 멈춘다.
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == null) continue;
			if (cnt++==K) break;
			
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
