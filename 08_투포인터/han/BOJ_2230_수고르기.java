package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws IOException {
		
		// 입력 받고 정렬까지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);
		
		// 포인터 두개 left, right
		int left = 0;
		int right = 0;
		
		int min = Integer.MAX_VALUE;
		
		// 큰수 인덱스 : right
		// 작은 수 인덱스 : left
		// 차이 tmp : numbers[right] - numbers[left]
		// 차이가 구하려는 값인 M 보다 작다면, 큰수를 더 크게 (차이를 늘리려고)
		// 차이가 구하려는 값인 M 보다 크다면, 작은수를 더 크게 (차이를 줄이려고)
		// 차이가 M이라면 정답찾았다. 더 이상 탐색할 필요 X
		// 근데 큰수는 작은 수 보다 커야 하므로 left == right 이면 right를 크게 
		while(right < N) {
			int tmp = numbers[right]-numbers[left];
			if (tmp == M) {System.out.println(M); return;}
			else if (left == right) {
				right++;
			} else if (tmp > M && tmp < min) {
				min = tmp;
				left++;
			} else if (tmp > M) {
				left++;
			} else {
				right++;
			}
		}
		System.out.println(min);
	}
}
