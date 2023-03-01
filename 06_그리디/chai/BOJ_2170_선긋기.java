package day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2170_선긋기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 두점의 위치는 int 범위이내이다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		int upper = 0;
//		int lower = 1000000000;
		
		boolean[] arr = new boolean[2000000000+1];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for (int j=start; j<=end; j++) {
				if (!arr[j+1000000000]) arr[j+1000000000] = true;
			}
		}
		int max = 0;
		int idx = 0;
		while (idx < arr.length) {
			int tmpIdx = 0;
			int tmpMax = 0; 
			if (arr[idx]) {
				while (arr[idx+tmpIdx]) {
					tmpMax++;
					tmpIdx++;
				}
				if (tmpMax > max) max = tmpMax;
				idx = idx+tmpIdx;
			}
		}
		System.out.println(max);
	}
}
