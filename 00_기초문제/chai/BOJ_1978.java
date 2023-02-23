import java.util.Scanner;

public class BOJ_1978 {
	public static boolean isPrime(int num) {
		if (num<2) return false;
		
		for (int i=2; i*i<=num; i++) {
			if (num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//반복돌면서 바로 입력 & 소수판별
		int cnt = 0;
		for (int i=0; i<n; i++) {
			// 숫자 입력
			int num = sc.nextInt();
			if (isPrime(num)) cnt++;			
		}
		sc.close();
		System.out.println(cnt);
	}
}
