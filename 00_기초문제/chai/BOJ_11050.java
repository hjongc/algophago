import java.util.Scanner;

public class BOJ_11050 {
	
	static int fac(int N) {
		if (N < 2) {
			return 1;
		}
		
		return N * fac(N-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(fac(n));
		System.out.println(fac(n-k));
		System.out.println(fac(k));
		System.out.println(fac(n) / fac(n-k) * fac(k));
	}
}
