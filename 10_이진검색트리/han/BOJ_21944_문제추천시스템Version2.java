package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21944_문제추천시스템Version2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<int[]> ts = new TreeSet<>((o1, o2)-> {
			if (o1[1] == o2[1]) return o1[0] - o2[0];
			else return o1[1] - o2[1];
		});
		
		TreeSet<int[]> ts2 = new TreeSet<>((o1, o2)-> {
			if (o1[2] == o2[2]) {
				if (o1[1] == o2[1]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			} else return o1[2] - o2[2];
		});
		
		
		int[][] difficulty = new int[100001][2];
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			
			ts.add(new int[] {P, L});
			ts2.add(new int[] {P, L, G});
			difficulty[P][0] = L;
			difficulty[P][1] = G;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String cmd = st.nextToken();
			switch (cmd) {
			case "add":
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				
				ts.add(new int[] {P, L});
				ts2.add(new int[] {P, L, G});
				difficulty[P][0] = L;
				difficulty[P][1] = G;
				break;
			case "solved":
				P = Integer.parseInt(st.nextToken());
				L = difficulty[P][0];
				G = difficulty[P][1];
				
				ts.remove(ts.higher(new int[] {P-1, L}));
				ts2.remove(ts2.higher(new int[] {P-1, L, G}));
				break;
			case "recommend":
				G = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					sb.append(ts2.lower(new int[] {0, 101, G})[0]).append("\n");
				} else {
					sb.append(ts2.higher(new int[] {0, 0, G})[0]).append("\n");
				}
				break;
			case "recommend2":
				x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					sb.append(ts.last()[0]).append("\n");
				} else {
					sb.append(ts.first()[0]).append("\n");
				}
				break;
			case "recommend3":
				x = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				if (x == 1) {
					if (ts.higher(new int[] {0, L}) == null) {
						sb.append("-1\n");
					} else {
						sb.append(ts.higher(new int[] {0, L})[0]).append("\n");
					}
				} else {
					if (ts.lower(new int[] {0, L}) == null) {
						sb.append("-1\n");
					} else {
						sb.append(ts.lower(new int[] {0, L})[0]).append("\n");
					}
				}
				break;
			default:
				break;
			}
		}
		System.out.print(sb);
	}
}
