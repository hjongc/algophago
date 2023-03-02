package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3151_합이0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (map.containsKey(in)) map.replace(in, map.get(in)+1);
			else map.put(in, 1);
		}
		
		int size = map.size();
		int[] numbers = new int[size];
		int cnt = 0;
		
		for(int in : map.keySet()) {
			numbers[cnt++] = in;
		}
		
		Arrays.sort(numbers);
		
		int ans = 0;
		
		for (int i = 1; i<N-1; i++) {
			int left = i;
			int right = i;
			while(left >= 0 && right < cnt) {
				int check = 0;
				boolean valid = false;
				if (left == i) check++;
				if (right == i) check++;
				if (map.get(numbers[i]) < check) valid = true;
				int tmp = numbers[left] + numbers[right] + numbers[i];
				if (tmp > 0) left--;
				else if (tmp < 0) right++;
				else {
					System.out.println( map.get(numbers[left])*map.get(numbers[right])*map.get(numbers[i]));
					System.out.println("left : "+numbers[left]+" right : "+numbers[right]+" i : "+numbers[i]);
					if (!valid) {
					ans+= map.get(numbers[left])*map.get(numbers[right])*map.get(numbers[i]);}
					if (right < cnt-1 && left > 0) {
						if (numbers[right+1] + numbers[left-1] < 0) {
							right++;
						} else {
							left--;
						}
					} else if (left > 0) {
						left--;
					} else {
						right++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
