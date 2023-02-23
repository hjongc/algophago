package 재귀;

import java.util.Scanner;

// BOJ_1629_곱셈
public class BOJ_1629_곱셈 {
	
	// 모듈러로 나눌 c 변수는 static
	static long c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		c = sc.nextInt();
		
		long result = pow(a, b);
		System.out.println(result);
	}
	
	// a^b % c 구하는 함수
	public static long pow(long a, long n) {
		//System.out.printf("a : %d / b : %d\n", a, n);
		
		// 지수가 1일 경우 그대로 리턴
		// 이걸 안하면 a^0을 호출하는데 그러면 끊임없이 도나? -> 그렇다.
		// a : 10 b : 0 반복하다가 java.lang.StackOverflowError
		if(n == 1) {
			return a % c;
		} else if (n % 2 == 0) {
			// 2^11%3 을 구하기 위해서 2^5%3 을 구해왔다.
			long temp = pow(a, n / 2);
			// return ((temp % c) * (temp % c)) % c;
			// 이미 모듈러해서 왔기 때문에 또 할 필요 없다 
			return temp * temp % c;
		} else {
			// 2^11%3 을 구하기 위해서 2^5%3 을 구해왔다.
			long temp = pow(a, n / 2);
			return (temp * temp % c) * (a % c) % c;
		}
		
	}
}