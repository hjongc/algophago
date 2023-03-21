package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_1539_이진검색트리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		
		TreeSet<Integer> ts = new TreeSet<>();
		int[] depth = new int[N+1];
		
		int first = Integer.parseInt(br.readLine());
		
		ts.add(first);
		depth[first] = 1;
		
		for (int i = 1; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			if (ts.lower(in) == null) {
				ts.add(in);
				depth[in] = depth[ts.higher(in)] + 1;
				ans += depth[in];
			} else if (ts.higher(in) == null) {
				ts.add(in);
				depth[in] = depth[ts.lower(in)] + 1;
				ans += depth[in];
			} else {
				ts.add(in);
				depth[in] = Math.max(depth[ts.higher(in)], depth[ts.lower(in)]) + 1;
				ans += depth[in];
			}
		}
		System.out.println(ans+1);
		
	}
	
}
