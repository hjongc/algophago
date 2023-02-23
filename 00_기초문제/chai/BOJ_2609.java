import java.util.Scanner;

public class BOJ_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		// 최대공약수 GCD
		// min부터 1씩 빼면서 a,b 모두 나눌 수 있는 수 구하기
		for (int i=min; i>0; i--) {
			if (a%i==0 && b%i==0) {
				System.out.println(i);
				break;
			}
		}
		
		// 최소공배수 LCM
		// max * n % min ==0 인지 확인
		int mul = 0;
		while (true) {
			mul++;
			if ((max*mul)%min==0) {
				System.out.println(max*mul);
				break;
			}
		}
		sc.close();
	}
}
