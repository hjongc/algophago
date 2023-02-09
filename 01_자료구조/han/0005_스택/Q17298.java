import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		Stack<set> stack = new Stack<>();
		int[] answer = new int[size];
		
		int idx = 0;
		
		stack.push(new set(idx++,Integer.parseInt(st.nextToken())));
		
		for (int i = 2; i<=size; i++) {
			int input = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && input > stack.peek().value) {
				set out = stack.pop();
				answer[out.idx] = input;
			} 
			stack.push(new set(idx++, input));
		}
		for (int ans : answer) {
			if (ans == 0) sb.append("-1 ");
			else sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}
}
class set {
	public int idx;
	public int value;
	public set(int idx, int value){
		this.idx = idx;
		this.value = value;
	}
}