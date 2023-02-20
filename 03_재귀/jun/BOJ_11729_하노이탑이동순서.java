package 재귀;

import java.util.Scanner;

public class BOJ_11729_하노이탑이동순서 {
	
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 원판 n개를 어디서 어디로 이동할지
		hanoi(N, 1, 3);
		
		System.out.println(count);
	}
	
	
	// 귀납적인 사고를 해야한다.
	// 어디서 어디로 어떤번호를 이동할지  -> 가 아님
	// 원판 n개를 어디서 어디로 이동할지
	
	// 원판 5개를 1 -> 3으로 옮기려면
	static void hanoi(int num, int from, int to) {
		System.out.println(num + "개 " + from + " " + to);
		
		if(num != 0) {
			// 원판 4개를 1 -> 2로 옮겨야한다
			// n - 1개를 나머지로 옮긴다
			count++;
			System.out.println("count" + count);
			hanoi(num-1, from, 6-from-to);

			
			// 5번 원판을 1 -> 3으로 옮긴다
			// n번 원판을 from에서 to로 옮긴다
			count++;
			System.out.println("count" + count);
			hanoi(1, from, to);


			// 4개 원판을 2 -> 3으로 옮긴다
			// n - 1개 원판을 to로 옮긴다
			count++;
			System.out.println("count" + count);
			hanoi(num-1, 6-from-to, to);

		}
		
	}
	
	
}
