import java.util.Scanner;

public class BOJ_11050_2 {
	
	static int binomial(int n, int k) {
		if (n == k || k == 0) {
			return 1;
		}
		
		return binomial(n-1, k-1) + binomial(n-1, k);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
	
		System.out.println(binomial(n,k));
	}
}
