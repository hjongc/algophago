import java.util.Scanner;

public class BOJ_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // < 1000;
		
		// 100 미만의 경우 
		if (n < 100) {
			System.out.println(n);
			return;
		}
		if (n == 1000) {
			System.out.println(144);
			return;
		}
		
		int cnt = 99;
		
		for (int i = 100; i <= n; i++) {
			int tmp = i;
			// 세자리 수
			int place1 = tmp % 10;
			tmp /= 10;
			int place2 = tmp % 10;
			tmp /= 10;
			int place3 = tmp % 10;

			if (place1-place2 == place2-place3) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
		
	}
}
