package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13414_수강신청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] queue = new String[M];
		HashMap<String, Integer> map = new HashMap<>();
		
		int cnt = 0;
		
		for (int i = 0; i<M; i++) {
			String in = br.readLine();
			if (map.containsKey(in)) {
				int tmp = map.get(in);
				queue[tmp] = null;
				map.replace(in, cnt);
				queue[cnt++] = in;
			} else {
				map.put(in, cnt);
				queue[cnt++] = in;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		cnt = 0;
		
		here: for (int i = 0; i<N; i++) {
			if (cnt >= M) break;
			while(queue[cnt] == null) {
				cnt++;
				if(cnt >= M) break here;
			}
			sb.append(queue[cnt++]).append("\n");
		}
		
		System.out.print(sb);
	}
}
