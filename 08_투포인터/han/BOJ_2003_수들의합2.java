package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 포인터 두개, left 초과 right 이하
		int left = 0;
		int right = 0;
		int sum = numbers[0];
		int ans = 0;
		while(right < N) {
			if (sum == M) {
				ans++;
				sum -= numbers[left++];
			} else if (left == right) {
				if (right == N-1) break;
				sum += numbers[++right];
			} else if (sum > M) {
				sum -= numbers[left++];
			} else {
				if (right == N-1) break;
				sum += numbers[++right];
			}
		}
		System.out.println(ans);
	}
}
