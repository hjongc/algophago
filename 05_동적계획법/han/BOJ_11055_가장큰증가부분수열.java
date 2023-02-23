import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] dp = new int[1001];
		
		int max = 0;
		
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
            max = 0;
			for (int j = 0; j<in; j++) {
				if (max < dp[j]) max = dp[j];
			}
			dp[in] = Math.max(dp[in], max+in);
		}
		
		max = 0;
		
		for (int i = 0; i<1001; i++) {
			if (dp[i] > max) max = dp[i]; 
		}
		
		System.out.println(max);
	}
}
