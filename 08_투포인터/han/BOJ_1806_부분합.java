package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		
		// 입력 받고 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 좌 포인터 : left
		// 우 포인터 : right
		// left 초과 right 이하의 모든 인덱스를 갖는 수의 합 : tmp
		int left = 0;
		int right = 0;
		int tmp = numbers[0];
		int min = Integer.MAX_VALUE;
		
		// tmp 가 S 보다 크다면 : 더 작아질 가능성 있으므로 left를 크게
		// tmp 가 S 보다 작다면 : 무조건 커야 하므로 right를 크게
		// tmp가 S보다 크고 만약 수열의 개수가 1이 된다면 더 이상 탐색할 필요 없다
		while(right < N) {
			if (tmp >= S && (right-left+1) < min) {
				min = right-left+1;
				if (min == 1) {
					System.out.println(1);
					return;
				}
				tmp -= numbers[left++];
			} else if (tmp < S) {
				if (++right == N) {
					break;
				} else {
					tmp += numbers[right];
				}
				
			} else if (tmp >= S) {
				tmp -= numbers[left++];
			}
		}
		
		// 못찾은 경우와 찾은 경우 판단
		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}
}
