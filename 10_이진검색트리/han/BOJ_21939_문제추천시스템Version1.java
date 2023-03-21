package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21939_문제추천시스템Version1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 난이도 저장 (문제번호, 난이도)
		HashMap<Integer, Integer> difficulty = new HashMap<>();
		// 문제들 저장
		TreeSet<Integer> problems = new TreeSet<>((o1, o2)-> {
			int i = difficulty.get(o1) - difficulty.get(o2);
			if (i > 0) return 1;
			else if (i<0) return -1;
			else return (o1-o2);
			
		});
		// 문제가 남아있는지 저장
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			difficulty.put(P, L);
			problems.add(P);
		}
		
		int commands = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<commands; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String cmd = st.nextToken();
			if (cmd.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				if (difficulty.containsKey(P)) difficulty.replace(P, L);
				else difficulty.put(P, L);
				problems.add(P);
			} else if (cmd.equals("solved")) {
				int P = Integer.parseInt(st.nextToken());
				problems.remove(P);
			} else {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					sb.append(problems.last()).append("\n");
					problems.remove(problems.last());
				} else {
					sb.append(problems.first()).append("\n");
					problems.remove(problems.first());
				}
			}
		}
		System.out.print(sb);
		
	}
}
