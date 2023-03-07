package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22857_가장긴짝수연속한부분수열small {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] isEven = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (in % 2 == 0) isEven[i] = true;
		}
		
		int left = 0;
		int right = 0;
		int cnt = (isEven[0]) ? 0 : 1;
		int tmp = (isEven[0]) ? 1 : 0;
		int max = (isEven[0]) ? 1 : 0;
		
		while(right < N-1) {
			if (cnt <= K) {
				if (isEven[++right]) {
					if(++tmp > max) max = tmp;
				} else {
					cnt++;
				}
			} else {
				if (isEven[left++]) {
					tmp--;
				} else {
					cnt--;
				}
			}
		}
		
		System.out.println(max);
	}
}
