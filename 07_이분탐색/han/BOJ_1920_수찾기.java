package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		int tc = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i<tc; i++) {
			int in = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			boolean found = false;
			while(start <= end) {
				int middle = (start+end)/2;
				if (in > numbers[middle]) {
					start = middle+1;
				} else if (in < numbers[middle]) {
					end = middle-1;
				} else {
					found = true;
					break;
				}
			}
			if (found) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
	}
}
