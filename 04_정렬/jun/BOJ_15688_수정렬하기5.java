package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15688_수정렬하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] counts = new int[2000001];
		int[] arr = new int[N];
		
		
		// 이 수는 절댓값이 1,000,000보다 작거나 같은 정수... 음수!
		// -1,000,000 ~ 0 ~ 1,000,000
		// 1,000,000 더하면 0 ~ 2,000,000
		// 숫자에 1000000 더해서 카운팅 정렬 및 누적합까지 한다
	
		// 숫자 입력 + count
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			counts[num + 1000000]++;
		}

		// 카운팅 정렬 누적합
		for(int i = 1; i <= 2000000; i++) {
			counts[i] += counts[i - 1];
		}
		
		// arr 배열에 정렬
		int[] arr2 = new int[N];
		for(int i = 0; i < N; i++) {
			// 누적합 인덱스에서 1 뺀 거가 새로운 인덱스
			arr2[ counts[arr[i] + 1000000] - 1 ] = arr[i];
			// 숫자 하나 넣어줬으니 누적합은 1 감소
			counts[arr[i] + 1000000]--;
		}
		
		
		for(int i = 0; i < N; i++) {
			sb.append(arr2[i] + "\n");
		}
		System.out.println(sb);
		
	}
}
