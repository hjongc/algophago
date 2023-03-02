package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2295_세수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int maximum = 0;
		
		Arrays.sort(numbers);
		int max = numbers[N-1];
		
		for (int i = N-2; i>=0; i--) {
			for (int j = i; j>=0; j--) {
				if (numbers[i]+numbers[j] > max) continue;
				int left = j;
				int right = N-1;
				while(left >= 0 && right > i) {
					int tmp = numbers[i]+numbers[j]+numbers[left];
					if (tmp < maximum) break;
					else if (tmp > max) left--;
					else if (tmp == numbers[right]) {
						maximum = tmp;
						break;
					} else if (numbers[i]+numbers[j]+numbers[left] < numbers[right]) {
						right--;
					} else {
						left--;
					}
				}
				
			}
		}
		System.out.println(maximum);
		
		
		
		
		
	}
}
