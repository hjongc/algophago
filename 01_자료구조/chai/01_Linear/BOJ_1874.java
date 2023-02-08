import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> que = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		
		// 1,2,3,4 ... n 까지 순서대로 큐에 넣어준다.
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			que.addLast(i+1);
		}
		
		
		for (int i=0; i<n; i++) {
			// 타겟넘버보다 작거나 같은 수를 큐에서 스택으로 옮겨준다.
			int target = Integer.parseInt(br.readLine());
			
			if (!que.isEmpty() && target >= que.peek()) {
				for (int j = que.peekFirst(); j<=target; j++) {
					stack.addLast(que.pollFirst());
					sb.append("+\n");
				}
			}
			
			if (target == stack.peekLast()) {
				stack.pollLast();
				sb.append("-\n");
			}
			
			// 아니라면 NO출력 
			else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
		
	}
}
