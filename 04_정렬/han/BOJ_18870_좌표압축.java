import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] input = new int[N];
		int[] sorted = new int[N];
		
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			input[i] = in;
			sorted[i] = in;
		}
		
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int cnt = 0;
		
		for (int in : sorted) {
			if (!map.containsKey(in)) {
				map.put(in, cnt++);
			}
		}
		
		for (int in : input) {
			sb.append(map.get(in)+" ");
		}
		
		System.out.println(sb);
	}
}
