

import java.util.Scanner;

public class BOJ_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] queue = new int[n];
 		
		int size = 0;
		int top = 0;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			
			if (s.equals("push")) {
				queue[top+size] = sc.nextInt();
				size++;
			}
			else if (s.equals("pop")) {
				if (size == 0) sb.append(-1).append("\n");
				else {
					size--;
					sb.append(queue[top]).append("\n");
					top++;
				}
				
			}
			else if (s.equals("size")) {
				sb.append(size).append("\n");
			}
			else if (s.equals("empty")) {
				if (size == 0) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if (s.equals("front")) {
				if (size == 0) sb.append(-1).append("\n");
				else {
					sb.append(queue[top]).append("\n");
				}
			}
			else if (s.equals("back")) {
				if (size == 0) sb.append(-1).append("\n");
				else {
					sb.append(queue[top+size-1]).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
