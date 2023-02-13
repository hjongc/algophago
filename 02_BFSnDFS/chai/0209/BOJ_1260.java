import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // node  
		int m = Integer.parseInt(st.nextToken()); // edge
		int v = Integer.parseInt(st.nextToken()); // initial node
		
		boolean[][] map = new boolean[n+1][n+1];
		boolean[] visit = new boolean[n+1];
		
		// for BFS
		Deque<Integer> que = new ArrayDeque<>();
		// for DFS
		Deque<Integer> stack = new ArrayDeque<>();
		
		// map
		for(int i=1; i<=m; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = true;
			map[end][start] = true;
		}
		
//		System.out.println(Arrays.deepToString(map));
		
		// DFS
		System.out.printf("%d ", v);
		visit[v] = true;
		
		for (int i=1; i<=n; i++) {
			if (map[v][i] == true) {
				stack.addLast(i);
				visit[i] = true;
				break;
			}
		}
		while (!stack.isEmpty()) {
			int cur = stack.pollFirst();
			System.out.printf("%d ", cur);
			for (int i=1; i<=n; i++) {
				if (map[cur][i] == true && visit[i] == false) {
					stack.addLast(i);
					visit[i] = true;
					
				}
			}
			
		}
		
		// BFS
		System.out.printf("\n%d ", v);
		visit = new boolean[n+1];
		visit[v] = true;
		
		for (int i=1; i<=n; i++) {
			if (map[v][i] == true) {
				que.addLast(i);
				visit[i] = true;
			}
		}
		
		while (!que.isEmpty()) {
			int cur = que.pollFirst();
			
			System.out.printf("%d ", cur);
			for (int i=1; i<=n; i++) {
				if (map[cur][i] == true && visit[i] == false) {
					que.addLast(i);
					visit[i] = true;
				}
			}
			
		}
		
	}
}

//[[false, false, false, false, false, false], 
// [false, false, true, false, false, false], 
// [false, true, false, false, false, true], 
// [false, false, false, false, true, false], 
// [false, false, false, true, false, true], 
// [false, false, true, false, true, false]]


