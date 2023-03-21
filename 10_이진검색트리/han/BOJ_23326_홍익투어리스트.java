package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_23326_홍익투어리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i<N; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				ts.add(i);
			}
		}
		
		int position = 0;
		
		for (int i = 0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int in = Integer.parseInt(st.nextToken())-1;
				if (ts.contains(in)) ts.remove(in);
				else ts.add(in);
			} else if (cmd == 2) {
				position = (position + Integer.parseInt(st.nextToken())) % N;
			} else {
				if (ts.contains(position)) {
					sb.append(0).append("\n");
				} else if (ts.higher(position) != null) {
					sb.append(ts.higher(position)-position).append("\n");
				} else if (ts.higher(-1) != null) {
					sb.append(ts.higher(-1)+(N-position)).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}
