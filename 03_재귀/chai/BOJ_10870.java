import java.util.Scanner;

public class BOJ_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(factorial(n));
	}
	public static int factorial(int N) {
		if (N==0) return 0;
		else if (N==1) return 1;

		return factorial(N-1) + factorial(N-2);
	}
}
