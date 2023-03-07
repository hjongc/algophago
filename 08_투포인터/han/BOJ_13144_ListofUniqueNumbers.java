package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144_ListofUniqueNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] unique = new boolean[100001];
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = N-1;
		int right = N-1;
		unique[numbers[N-1]] = true;
		boolean isUnique = true;
		int cnt = 1;
		long ans = 1;
		while(left >= 0) {
			if (isUnique) {
				if (left == 0) break;
				if (unique[numbers[--left]]) {
					isUnique = false;
				} else {
					unique[numbers[left]] = true;
					ans += (++cnt);
				}
			}
			else {
				while(numbers[left] != numbers[right]) {
					unique[numbers[right]] = false;
					right--;
					cnt--;
				} 
				right--;
				ans += cnt;
				isUnique = true;
			}
		}
		System.out.println(ans);
	}
}
