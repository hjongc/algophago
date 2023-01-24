import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 방번호
		sc.close();
		
		int[] nums = new int[10];
		
		
		while (n!=0) {
			nums[n%10]++;
			n/=10;
		}q
		
		// 6 & 9
		nums[9] = (nums[9] + nums[6]+1)/2;
		nums[6] = 0;
		
		System.out.println(Arrays.stream(nums).max().getAsInt());
	}
}
