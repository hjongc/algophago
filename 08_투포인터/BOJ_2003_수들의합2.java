package day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == M) cnt++;
		}
		
		int left = 0;
		int right = 1;
		if (N == 1) {
			System.out.println(cnt);
			return;
		}
		int tmpSum = arr[left] + arr[right];
		
		while (true) {
			// 만약 tmpSum이 M보다 작다면 
			// right를 옮겨준다. (범위 내라면)
			if (tmpSum < M) {
				
				if (right+1 >= N) break;
				tmpSum += arr[++right];
			}
			
			// 다시 tmpSum >= M인지 확인
			// 만약 같다면 cnt올려준다  
			// 이후 현재 left값을 tmpSum에서 뺴고 
			// left를 옮겨준다.
			// 만약 left == right라면 right도 옮겨준다.
			if (tmpSum >= M) {
				System.out.printf("%d %d %d\n", left, right, tmpSum);
				if (tmpSum == M) cnt++;
				tmpSum -= arr[left++];
				
				if (left == right) {
					if (right+1 >= N) break;
					tmpSum += arr[++right];
				}
			}

		}
		System.out.println(cnt);
	}
}