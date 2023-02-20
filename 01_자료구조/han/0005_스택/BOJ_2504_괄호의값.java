import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray();
		
		Stack<Integer> stk = new Stack<>();
				
		for (int i = 0 ; i<in.length; i++) {
			if (stk.isEmpty()) {
				if (in[i] == '(') stk.push(Integer.valueOf(in[i])*-1); // 40
				else if (in[i] == ')') stk.push(Integer.valueOf(in[i])*-1); // 41
				else if (in[i] == '[') stk.push(Integer.valueOf(in[i])*-1); // 91
				else if (in[i] == ']') stk.push(Integer.valueOf(in[i])*-1); // 93
				else stk.push(Integer.valueOf(in[i]));
			} else if (in[i] == '(' || in[i] == '[') {
				stk.push(Integer.valueOf(in[i])*-1);
			} else if (in[i] == ')') {
				if (stk.peek() > 0) {
					int tmp = stk.pop();
					if (stk.isEmpty() || stk.peek() != -40) {
						System.out.println(0); return;
					} else {
						stk.pop();
						if (!stk.isEmpty() && stk.peek() > 0) {
							int tmp2 = stk.pop();
							stk.push(tmp2 + tmp*2);
						} else if (stk.isEmpty()) {
							stk = new Stack<>();
							stk.push(tmp*2);
						} else {
							stk.push(tmp*2);
						}
					}
				} else if (stk.peek() == -40) {
					stk.pop();
					if (!stk.isEmpty() && stk.peek() > 0) {
						int tmp = stk.pop();
						stk.push(2+tmp);
					} else {
						stk.push(2);
					}
				} else {
					System.out.println(0); return;
				}
			} else if (in[i] == ']') {
				if (stk.peek() > 0) {
					int tmp = stk.pop();
					if (stk.isEmpty() || stk.peek() != -91) {
						System.out.println(0); return;
					} else {
						stk.pop();
						if (!stk.isEmpty() && stk.peek() > 0) {
							int tmp2 = stk.pop();
							stk.push(tmp2 + tmp*3);
						} else if (stk.isEmpty()) {
							stk = new Stack<>();
							stk.push(tmp*3);
						} else {
							stk.push(tmp*3);
						}
					}
				} else if (stk.peek() == -91) {
					stk.pop();
					if (!stk.isEmpty() && stk.peek() > 0) {
						int tmp = stk.pop();
						stk.push(3+tmp);
					} else {
						stk.push(3);
					}
				} else {
					System.out.println(0); return;
				}
			} else {
				stk.push(Integer.valueOf(in[i])*-1);
			}
		}
		if (stk.isEmpty() || stk.peek() < 0 || stk.size()>1) System.out.println(0);
		else System.out.println(stk.pop());
	}
}
