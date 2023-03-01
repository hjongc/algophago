package day0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine()); 
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 셋으로 만들어 중복을 없앤다.
		Set<Integer> set = new HashSet<>(Arrays.asList(arr));
		
		// 셋을 리스트로 만든다.
		ArrayList<Integer> list = new ArrayList<>(set);
		
		// 리스트를 정렬한다.
		Collections.sort(list, Collections.reverseOrder());
		
		// 맵에 각 수의 값을 저장한다.
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i=0; i<list.size(); i++) {
			map.put(list.get(i), list.size()-1-i);
		}
		
		for (int i=0; i<N; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.println(sb);
	}
}
