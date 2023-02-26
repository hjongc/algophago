package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501_주식 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for (int tc = 0; tc<testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int[] days = new int[N];
			
			for (int i  = 0; i<N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			int maximum = 0;
			long answer = 0;
			
			for (int i = N-1; i>=0; i--) {
				if (days[i] > maximum) {
					maximum = days[i];
				} else {
					answer += (maximum - days[i]);
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
}
