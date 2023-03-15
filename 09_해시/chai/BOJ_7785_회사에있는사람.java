package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_7785_회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int n = Integer.parseInt(br.readLine());
		Map<String, Boolean> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String status = st.nextToken();
			
			if (status.equals("enter")) {
				map.put(name, true); // 회사에 있으면 true 
			}
			
			// leave가 입력되면
			// 그 사람은 이전에 무조건 엔터 상태임을 가정. 
			else {
				map.remove(name);
			}
		}
		
		Object[] arr = map.keySet().toArray();
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i=arr.length-1; i>=0; i--) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
