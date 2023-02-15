import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stk = new Stack<>();
		
		long cnt = 0;
		
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(br.readLine());
			if (stk.isEmpty()) {stk.push(new int[] {in, 1}); continue;}
			int tmp = 0;
			while(!stk.isEmpty()) {
				if (stk.peek()[0] == in) {
					tmp = stk.pop()[1];
					cnt += tmp;
				} else if (stk.peek()[0] < in) {
					cnt += stk.pop()[1];
				} else {
					cnt += 1;
					break;
				}
			}
			stk.push(new int[] {in, ++tmp});
			
		}
		System.out.println(cnt);
	}
}
