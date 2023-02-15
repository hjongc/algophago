import java.util.Scanner;

public class BOJ_11729 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		// 총 횟수 구하는 공식 
		sb.append((int) Math.pow(2, K)-1+"\n");
		hanoi(K, 1, 2, 3);
		System.out.println(sb);
		
	}
	
	// 귀납적으로 생각하자,,,?
	public static void hanoi(int n, int start, int sub, int end) {
		if (n==1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		
		// 원판 k개를 옮긴다면 k-1개를 보조기둥에 옮겨야한다. 
		hanoi(n-1, start, end, sub);
		// 가장 큰 원판을 목표지점에 놓는다. 
		sb.append(start+" "+end+"\n");
		// 보조기둥에 놓았던 k-1개의 원판을 다시 목표지점에 놓는다. 
		hanoi(n-1, sub, start, end);
	}
}
