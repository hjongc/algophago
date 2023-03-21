package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_19700_수업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> groups = new TreeSet<>();
		HashMap<Integer, Integer> groupcnt = new HashMap<>();
		
		int[] height = new int[N];
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int h = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map.put(h, k);
			
			height[i] = h;
		}
		
		Arrays.sort(height);
		
		for (int i = N-1; i>=0; i--) {
			int h = height[i];
			int k = map.get(h);
			
			if (groups.lower(k) == null) {
				groups.add(1);
				if (groupcnt.containsKey(1)) groupcnt.replace(1, groupcnt.get(1)+1);
				else groupcnt.put(1, 1);
			} else {
				int tmp = groups.lower(k);
				int cnt = groupcnt.get(tmp);
				
				if (cnt > 1) {
					groupcnt.replace(tmp, groupcnt.get(tmp) - 1);
					if (groups.contains(tmp+1)) {
						groupcnt.replace(tmp+1, groupcnt.get(tmp+1) + 1);
					} else {
						groupcnt.put(tmp+1, 1);
						groups.add(tmp+1);
					}
				} else {
					groupcnt.remove(tmp);
					groups.remove(tmp);
					if (groups.contains(tmp+1)) {
						groupcnt.replace(tmp+1, groupcnt.get(tmp+1) + 1);
					} else {
						groupcnt.put(tmp+1, 1);
						groups.add(tmp+1);
					}
				} 
				
			}
		}
		int ans = 0;
		for(int i : groupcnt.values()) {
			ans += i;
		}
		System.out.println(ans);
		
	}
}
