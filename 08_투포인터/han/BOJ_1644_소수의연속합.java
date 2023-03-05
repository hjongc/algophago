package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1644_소수의연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] primes = new boolean[N+1];
		
		primes[0] =true;
		primes[1] =true;
		
		for (int i = 2; i<=N; i++) {
			if (primes[i]) continue;
			else {
				for (int j = 2; j <= N/i; j++) {
					primes[i*j] = true;
				}
			}
		}
		int left = 2;
		int right = 2;
		int sum = 2;
		int cnt = 0;
		while(right <= N) {
			if (left == right) {
				if (left == N) {
					cnt++;
					break;
				} else {
					while(++right <= N && primes[right]) {}
					if (right > N) break;
					else sum += right;
				}
			} else if (sum < N) {
				while(++right <= N && primes[right]) {}
				if (right > N) break;
				else sum += right;
			} else if (sum > N) {
				sum -= left;
				while(++left <= right && primes[left]) {}
				if (left > right) left--;
			} else if (sum == N) {
				cnt++;
				while(++right <= N && primes[right]) {}
				if (right > N) break;
				else sum += right;
			}
		}
		System.out.println(cnt);
	}
}
