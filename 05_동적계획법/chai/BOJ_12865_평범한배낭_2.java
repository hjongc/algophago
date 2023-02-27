package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭_2 {
	
	static Integer[][] dp;
	static int[] W;
	static int[] V;
	
	public static void main(String[] args) throws IOException {
		// top-down 방식 (dp와 재귀 활용)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게
		
		W = new int[N];
		V = new int[N];
		dp = new Integer[N][K+1];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 무게 
			V[i] = Integer.parseInt(st.nextToken()); // 가치
		}
		System.out.println(Knapsack(N-1, K));
	}

	static int Knapsack(int i, int k) {
		// i가 범위 밖이 된다면?
		if (i<0) return 0;
		
		// 탐색하지 않은 위치라면?
		if (dp[i][k] == null) {
			// 현재 인덱스의 물건을 담지 못한다면?
			if (W[i] > k) {
				dp[i][k] = Knapsack(i-1, k);
			}
			// 현재 인덱스의 물건을 담을 수 있는 경우?
			else {
				dp[i][k] = Math.max(Knapsack(i-1, k), Knapsack(i-1, k-W[i])+V[i]);
			}
		}
		return dp[i][k];
	}

}

