import java.util.Scanner;

public class BOJ_10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		int[] stack = new int[n];
		int top = -1; //top idx == size
		for (int i=0; i<n; i++) {
			String command = sc.next();
			
			if (command.equals("push")) {
				stack[++top] = sc.nextInt();
			}
			else if (command.equals("pop")) {
				
				if (top == -1) sb.append(-1).append("\n");
				else {
					sb.append(stack[top--]).append("\n");
				}				
			}
			else if (command.equals("size")) {
				sb.append(top+1).append("\n");
			}
			
			else if (command.equals("empty")) {
				if (top == -1) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if (command.equals("top")) {
				if (top == -1) sb.append(-1).append("\n");
				else sb.append(stack[top]).append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
