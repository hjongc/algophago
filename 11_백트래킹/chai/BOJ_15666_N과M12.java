package day0328;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15666_N과M12 {
	static int N, M;
	static int[] nums, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		
		sel = new int[M];
		
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		func(0, 0);
		
	}
	private static void func(int d, int cur) {
		if (d==M) {
			for (int i=0; i<M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int tmp = -1;
		for (int i=cur; i<N; i++) {
			if (tmp!=nums[i]) {
				sel[d] = nums[i];
				tmp = sel[d];
				func(d+1, i);
			}
		}
	}
}
