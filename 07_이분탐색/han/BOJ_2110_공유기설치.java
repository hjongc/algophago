package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] houses = new int[N];
		
		for (int i = 0; i<N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		
		int left = 1;
		int right = ((houses[N-1]-houses[0])/(C-1));
		
		
		here: while(left <= right) {
			int middle = (right+left)/2;
			int start = houses[0];
			int cnt = 1;
			for (int j = 1; j<N; j++) {
				if (houses[j] - start >= middle) {
					start = houses[j];
					if (++cnt >= C) {
						left = middle+1;
						continue here;
					} 
				} else {
					continue;
				}
			}
			right = middle-1;
		}
		System.out.println(left-1);
	}
}
