package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21939_문제추천시스템Version1_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		int[] difficulty = new int[100001];
		
		TreeSet<Integer> ts = new TreeSet<>((o1, o2) ->  {
			if (difficulty[o2] == difficulty[o1]) return o2-o1;
			else return difficulty[o2] - difficulty[o1];
		});
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			difficulty[P] = L;
			ts.add(P);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
				case("add") :
					int P = Integer.parseInt(st.nextToken());
					int L = Integer.parseInt(st.nextToken());
					difficulty[P] = L;
					ts.add(P);
					break;
				case ("solved") :
					ts.remove(Integer.parseInt(st.nextToken()));
					break;
				case ("recommend") :
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						sb.append(ts.first()).append("\n");
					}
					else {
						sb.append(ts.last()).append("\n");
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
