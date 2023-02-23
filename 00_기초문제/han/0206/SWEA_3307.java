import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<test_case; i++) {
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int[] num = new int[size+1];
			int[] dp = new int[size+1];
			
			for (int j = 1; j<=size; j++) {
				int input = Integer.parseInt(st.nextToken());
				num[j] = input;
				for (int k = 1; k<j; k++) {
					if (num[k] < num[j]) dp[j] = Math.max(dp[j], dp[k]+1);
				}
			}
			int max = 0;
			for (int j = 0; j<dp.length; j++) {
				if (dp[j]>max) max = dp[j];
			}
			sb.append("#").append(i+1).append(" ").append(max+1).append("\n");
		}
		System.out.println(sb);
	}
}
