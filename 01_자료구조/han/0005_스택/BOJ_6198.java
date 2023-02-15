import java.util.Scanner;
import java.util.Stack;

public class BOJ_6198 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int buildingNum = sc.nextInt();
		
		Stack<Integer> stk = new Stack<>();
		
		long cnt = 0;
		
		for (int i = 0; i<buildingNum; i++) {
			int in = sc.nextInt();
			if (stk.isEmpty()) {stk.push(in); continue;}
			while (!stk.isEmpty() && in >= stk.peek()) {
				stk.pop();
			}
			cnt += stk.size();
			stk.push(in);
		}
		
		System.out.println(cnt);
	}
}
