package day0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		// 배열에 입력을 저장 
		// 만약 입력된 수가 S를 넘는다면 바로 종료 
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp >= S) {
				System.out.println(1);
				return;
			}
			arr[i] = tmp;
		}
		
		int min = Integer.MAX_VALUE;
		
		int left = 0;
		int right = 0;
		int tmpSum = arr[left];
		
		// 종료조건 
		// min이 2가 됐을 때 
		// right를 끝까지 옮겼음에도 S를 넘지 못했을 때.
		while (min > 2 && right+1 <= N) {
            // 길이가 S보다 크면 min 업데이트하고
            // left 옮겨주기
			if (tmpSum >= S) {
				// 길이가 min보다 작으면 업데이트
				if (right-left+1<min) {
					min = right-left+1;
				}
				// tmpSum에서 arr[left]를 빼주고 
				// LEFT를 한칸 옮겨준다. 
				tmpSum -= arr[left++];
			}
            // 길이가 S보다 작으면 right를 옮겨준다.
			else {
				if (right+1 >= N) break;
				tmpSum += arr[++right];
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}
}