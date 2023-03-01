package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] numbers = new int[N];
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		long min = Long.MAX_VALUE;
		int[] minMember = new int[3];
		
		here: for (int i = 1; i<N-1; i++) {
			int left = i-1;
			int right = i+1;
			while(left >= 0 && right < N) {
				long tmp = (long)numbers[left] + (long)numbers[right] + (long)numbers[i];
				if (Math.abs(tmp) < min) {
					min = Math.abs(tmp);
					minMember[0] = numbers[left];
					minMember[1] = numbers[i];
					minMember[2] = numbers[right];
				}
				if (tmp > 0) left--;
				else if (tmp < 0) right++;
				else {
					min = 0;
					break here;
				}
			}
			
		}
		sb.append(minMember[0]+" "+minMember[1]+" "+minMember[2]);
		System.out.println(sb);
	}
}
