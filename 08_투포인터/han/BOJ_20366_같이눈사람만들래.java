package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20366_같이눈사람만들래 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] snows = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i<N; i++) {
			snows[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snows);
		
//		int A_left = 1;
//		int A_right = 2;
		int min = Integer.MAX_VALUE;
		
		for (int A_left = 1; A_left < N-1; A_left++){
			for (int A_right = A_left+1; A_right < N; A_right++) {
				int A_sum = snows[A_left] + snows[A_right];
				int B_left = 0;
				int B_right = N-1;
				while(B_left < A_left && B_right > A_right) {
					int B_sum = snows[B_left] + snows[B_right];
					int tmp = A_sum - B_sum;
					if (tmp == 0) {
						System.out.println(0);
						return;
					} else if (tmp < 0) {
						B_right--;
					} else if (tmp > 0) {
						B_left++;
					} 
					if (Math.abs(tmp) < min) min = Math.abs(tmp);
				}
				
			}
		}
		System.out.println(min);
	}
}
