import java.util.Scanner;

public class BOJ_1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=0; i<t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int max = Math.max(a, b);
			int min = Math.min(a, b);
			
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
		}
		sc.close();
	}
}
