import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		if (n==1) {
			System.out.println(1);
			return;
		}
		
		int sum = 1;
		int m = 1; // 6의 배수로 올라감.
		while (sum<n) {
			sum += m*6;
			
			if (n<=sum) {
				System.out.println(m+1);
				return;
			}
			
			m++;
		}
		
		
	}
}