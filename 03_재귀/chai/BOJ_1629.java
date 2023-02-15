import java.util.Scanner;

public class BOJ_1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		
		System.out.println(recursion(A, B, C)%C);
	}
	
	public static long recursion(long a, long b, long c) {
		if (b==1) return a%c;
		
		long val = recursion(a, b/2, c);
		
		if (b%2==0) { // 짝수일 떄
			return val * val % c;
		} 
		return val * val % c * a % c;
		
	}
}
