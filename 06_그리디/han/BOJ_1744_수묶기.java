package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744_수묶기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numbers);
		
		int minus = 0;
		int zero = 0;
		int answer = 0;
		
		for (int i = 0; i<N; i++) {
			if (numbers[i] < 0) minus++;
			else if (numbers[i] == 0) zero++;
			else break;
		}
		
		int plus = N - minus - zero;
		
		for (int i = 0; i < plus/2; i++) {
			// 1,1 인경우 1*1보다 1+1
			if (numbers[N-1-i*2] * numbers[N-2-i*2] > numbers[N-1-i*2] + numbers[N-2-i*2])
				answer += numbers[N-1-i*2] * numbers[N-2-i*2];
			else answer += (numbers[N-1-i*2] + numbers[N-2-i*2]);
		}
		if (plus % 2 == 1) answer += numbers[N-plus];
		
		for (int i = 0; i< minus/2; i++) {
			answer += numbers[2*i] * numbers[2*i + 1];
		}
		if (minus % 2 == 1) {
			// 0이 있는경우 더하는것보다 0곱하기
			if (zero == 0) answer += numbers[minus-1];
		}
		
		System.out.println(answer);
	}
}
