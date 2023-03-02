package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1477_휴게소세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] highway = new int[N+2];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i<N; i++) {
			highway[i] = Integer.parseInt(st.nextToken());
		}
		highway[N] = 0;
		highway[N+1] = L;
		
		Arrays.sort(highway);
		
		int left = 1;
		int right = L/M;
		
		here: while(left <= right) {
			int middle = (right+left)/2;
			int start = highway[0];
			int cnt = 0;
			for (int j = 1; j<N+2; j++) {
				while (highway[j] - start > middle) {
					start += middle;
					if (++cnt > M) {
						left = middle+1;
//						right = middle-1;
						continue here;
					} 
				
				}
				start = highway[j];
			}
//			left = middle+1;
			right = middle-1;
		}
		System.out.println(left);
		
		
	}
}
