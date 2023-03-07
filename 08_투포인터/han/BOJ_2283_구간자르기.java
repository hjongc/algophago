package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2283_구간자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] lines = new int[1000001];
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lines[start]++;
			lines[end]--;
			max = (end > max) ? end : max;
			min = (start < min) ? start : min;
		}
		
		for (int i = min+1; i<=max; i++) {
			lines[i] += lines[i-1];
		}
		
		int start = min;
		int end = min;
		int sum = 0;
		while(end < 1000001) {
			if (sum == K) {
				start = (start == min) ? 0 : start;
				System.out.println(start+" "+end);
				return;
			} else if (sum < K) {
				sum += lines[end++];
			} else {
				sum -= lines[start++];
			}
		}
		System.out.println("0 0");
		// 미친 반례...
		// 2 10
		// 1 6
		// 1 6
		// 이건 1 6이 아니고 0 6...
	}
}
