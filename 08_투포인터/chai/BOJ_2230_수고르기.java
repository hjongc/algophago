package day0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230_수고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		long[] nums = new long[N];
		for (int i=0; i<N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(nums);
		
		
		int left = 0;
		int right = 0;
		long minGap = Long.MAX_VALUE;
		while (left<=N-1 && right<=N-1) {
//			System.out.printf("%d %d\n", left, right);
			long tmpGap = nums[right]-nums[left];
			
			if (minGap>tmpGap && tmpGap>=M) {
				minGap = tmpGap;
			}
			// 가장 작은 값에서부터 출발한다. 
			// 만약 기준 값보다 차이가 크면 
			// left를 더 큰 값으로 옮긴다. 
			if (tmpGap>M) {
				left++;
			}
			// 만약 기준 값보다 차이가 작으면 
			// right를 더 큰 값으로 옮긴다. 
			else if (tmpGap<M) {
				right++;
			}
			
			// 탈출조건
			// 왼쪽값과 오른쪽 값의 차이가 M이 됐을 때
			// 왼쪽값이 오른쪽 값과 같거나 커졌을 때
			else if (tmpGap==M) {
				minGap = M;
				break;
			}
		}
		System.out.println(minGap);
	}
}

//3 2
//1
//2
//4
