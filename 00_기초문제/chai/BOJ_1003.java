import java.util.Scanner;

public class BOJ_1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		// size 먼저 체크
		int max = 0;
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			nums[i] = tmp;
			if (max < tmp) max = tmp;
		}
		
		int[] zero = new int[max+2];
		int[] one = new int[max+2];
		
		zero[0] = 1;
		one[0] = 0;
		
		zero[1] = 0;
		one[1] = 1;
		
		for (int i = 2; i < max+1; i++) {
			zero[i] = zero[i-2] + zero[i-1];
			one[i] = one[i-2] + one[i-1];
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(zero[nums[i]]); 
			System.out.print(" ");
			System.out.print(one[nums[i]]); 
			System.out.println();
		}
		
	}
}


// fibonacci
// n   0   1
// 0   1   0
// 1   0   1
// 2   1   1
// 3   1   2
// 4   2   3
// 5   3   5
// 6   5   8