import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 두 문자열의 배열 str1, 2
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		// 길이의 공통부분의 최대값을 저장할 배열 dp
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for (int i = 1; i<=str1.length; i++) {
			
			// 최대값 저장용 변수
			int max = 0;
			
			// 해당 문자열 이전까지 최대값 찾기
			for (int j = 1; j<=str2.length; j++) {
				if (dp[i-1][j-1] > max) max = dp[i-1][j-1];
				
				// 만약 해당 문자열이 같다면, 문자열 이전최대값 + 1만큼의 공통 문자열 생성가능
				if (str1[i-1] == str2[j-1]) {
					dp[i][j] = max+1;
					// 해당 문자열이 같지 않다면, 이전 최대값만큼만 
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int max = 0;
		
		// 최대값 구하고 출력
		for (int i = 1; i<=str2.length; i++) {
			if (max < dp[str1.length][i]) max = dp[str1.length][i];
		}
		
		System.out.println(max);
	}
}