package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 갯수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무 수
		
		int[] heights = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(heights);
		
		
		int start = 0;
		int end = heights[N-1];
		
		while (start <= end) {
			int mid = (start+end)/2;
			long tmpSum = 0;
			
			for (int i=0; i<N; i++) {
				if (heights[i]-mid>0) { 
					tmpSum += (heights[i]-mid);
				}
			}
			if (tmpSum < M) {
				// 높이를 내려서 더 자르도록 해야함
				end = mid-1;
			}
			else { // tmpSum > M
				// 높이를 높여서 덜 자르도록 해야함.
				start = mid+1;
			}
		}
		System.out.println(end);
	}
}
