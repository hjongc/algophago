package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] lines = new int[N][2];
		
		int max = 0;
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			lines[i][0] = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (end > max) max = end;
			lines[i][1] = end;
		}
		
		int start = 0;
		int end = 1;
		int sum = 0;
		boolean found = true;
		while(sum != K) {
			sum = 0;
			if (start == end) {
				end++;
				continue;
			}
			for (int i = 0; i<N; i++) {
				if (lines[i][0] < end) {
					sum += (Math.min(lines[i][1], end) - Math.max(lines[i][0], start));
				}
			}
			if (sum > K) {
				start++;
			} else if (sum < K){
				end++;
			}
			if (end > max) {
				found = false;
				break;
			}
		}
		if (!found) {
			start = 0;
			end = 0;
		}
		System.out.println(start+" "+end);
	}
}
