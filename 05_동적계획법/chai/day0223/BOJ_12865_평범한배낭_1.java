package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭_1 {
	public static void main(String[] args) throws IOException {
		// bottom-up 방식 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		// N+1로 할당하는 이유 
		// => i번째 무게를 담을 수 없는 경우 이전 행의 값을 가져오게되는데
		//    이를 용이하게 가져오기 위해서
		int[][] dp = new int[N+1][K+1]; 
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 무게 
			V[i] = Integer.parseInt(st.nextToken()); // 가치
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				// i번째 무게를 담을 수 없을 경우
				// i번째 아이템 무게보다 무게제한이 작으면
				// i-1번째 아이템까지의 가치합을 저장
				if (W[i] > j) { 
					dp[i][j] = dp[i-1][j];  
				}
				// i번째 무게를 담을 수 있는 경우
				// i-1번째까지 담은 최대 가치합과 
				// 새롭게 i번째 물건을 담은 가치합을 비교해서 최대값을 저장
				else { 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
					
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}

