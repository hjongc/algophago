package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14921_용액합성하기{
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
		
		int left = 0;
		int right = N-1;
		
		while(left < right) {
			int tmp = numbers[left]+numbers[right];
			if (Math.abs(tmp) < Math.abs(min)) {
				min = tmp;
			}
			if (tmp > 0) {
				right--;
			} else if (tmp < 0) {
				left++;
			} else {
				min = 0;
				break;
			}
		}
		System.out.println(min);
	}
}