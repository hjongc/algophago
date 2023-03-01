package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18869_멀티버스II {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] input = new int[M][N];
		
		for (int i = 0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int[] sorted = new int[N];
			for (int j = 0; j<N; j++) {
				int in = Integer.parseInt(st.nextToken());
				input[i][j] = in;
				sorted[j] = in;
			}
			Arrays.sort(sorted);
			
			for (int j = 0; j<N; j++) {
				int current = input[i][j];
				int start = 0;
				int end = N-1;
				while(start <= end) {
					int middle = (start+end)/2;
					if (current < sorted[middle]) {
						end = middle-1;
					} else if (current > sorted[middle]) {
						start = middle+1;
					} else if (middle > 0 && current == sorted[middle-1]) {
						end = middle-1;
					} else {
						start = middle;
						break;
					}
				}
				input[i][j] = start;
			}
		}
		int cnt = 0;
		for (int i = 0; i<M; i++) {
			for (int j = i+1; j<M; j++) {
				if (Arrays.equals(input[i], input[j])) {
					cnt++;
					continue;
				}
			}
		}
		System.out.println(cnt);
	}
}
