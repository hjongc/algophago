package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467_용액2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] numbers = new int[N];
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		int min = Integer.MAX_VALUE;
		int[] minMember = new int[2];
		
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			int tmp = numbers[left]+numbers[right];
			if (Math.abs(tmp) < min) {
				min = Math.abs(tmp);
				minMember[0] = numbers[left];
				minMember[1] = numbers[right];
			}
			if (tmp > 0) {
				right--;
			} else if (tmp < 0) {
				left++;
			} else {
				min = 0;
				minMember[0] = numbers[left];
				minMember[1] = numbers[right];
				break;
			}
		}
		System.out.println(minMember[0]+" "+minMember[1]);
	}
}