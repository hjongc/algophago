package han;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1202_보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<int[]> gems = new ArrayList<>();
		
		TreeSet<Integer> bags = new TreeSet<>();
		
		HashMap<Integer, Integer> bagsCount = new HashMap<>();
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			gems.add(new int[] {M, V});
		}
		
		for (int i = 0; i<K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			bags.add(tmp);
			if (bagsCount.containsKey(tmp)) {
				bagsCount.replace(tmp, bagsCount.get(tmp)+1);
			} else {
				bagsCount.put(tmp, 1);
			}
		}
		
		Comparator<int[]> cmp = new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		};
		
		Collections.sort(gems, cmp);
		
		long ans = 0;
		
		for (int i = 0; i<gems.size(); i++) {
			int[] in = gems.get(i);
			int M = in[0];
			int V = in[1];
			
			if (bags.higher(M-1) == null) {
				continue;
			} else {
				int tmp = bags.higher(M-1);
				if (bagsCount.get(tmp) > 1) {
					bagsCount.replace(tmp, bagsCount.get(tmp)-1);
				} else {
					bags.remove(tmp);
				}
				ans += V;
			}
		}
		System.out.println(ans);
	}
}
