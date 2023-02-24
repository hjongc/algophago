import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988_123더하기3 {
	
	public static long[] dp;
	
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] tc = new int[N];
        for (int i = 0; i<N; i++){
            int test_case = Integer.parseInt(br.readLine());
            if(test_case > max) max = test_case;
            tc[i] = test_case;
        }
        dp = new long[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i<max+1; i++) {
        	dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
        }
        for (int i = 0; i<N; i++) {
        	sb.append(dp[tc[i]]).append("\n");
        }
        System.out.println(sb);
    }
}

