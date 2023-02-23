package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		// items를 무게 순으로 정렬하고
		// dp배열을 채울 때 제한보다 item 무게가 큰 시점에서 break하면 
		// 더 효율적일수도?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int min = 100000; // item 최소 무게보다 작으면 0 
		int[][] items = new int[N][2]; // 물건들을 담을 배열 
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken()); // 무게 
			items[i][1] = Integer.parseInt(st.nextToken()); // 가치
			min = Math.min(min, items[i][0]);
		}
		
		// 배낭 제한을 1부터 N까지 순차적으로 늘려가며 dp배열 채우기
		// 아이템이 N개 이므로 아이템 중복사용을 막을 수 있다.
		int[][] dp = new int[K+1][N];
		for (int i=1; i<=K; i++) {
			for (int j=0; j<N; j++) {
				if (i < min) dp[i] = 0;
				
				// 가치합이 최대가 되는 아이템을 넣을 때
				// 각 아이템은 한 번만 사용할 수 있다.
				int maxIdx = -1;
				for (int j=0; j<N; j++) {
					// 현재 제한무게보다 item무게가 크거나 작고 
					// 이미 적혀져있는 가치합보다 클 때
					if (i>=items[j][0] && dp[i] < dp[i-items[j][0]]+items[j][1]) {
						dp[i] = dp[i-items[j][0]]+items[j][1];
					}
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[K]);
	}
}

