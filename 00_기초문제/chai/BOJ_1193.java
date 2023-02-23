import java.util.Scanner;

public class BOJ_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		// 몇 번째 줄인지 먼저 알아야한다.
		int sum = 0; // sum < n
		int line = 0; // ?th line
		while (sum < n) {
			line++;
			sum += line;
		}
		// 홀수인지 짝수인지?
		
		int a;
		int b;
		if (line%2==0) {
			a = 1;
			b = line;
			
			for (int i=1; i<n-(sum-line); i++) {
				a++;
				b--;
			}
		}
		else {
			a = line;
			b = 1;
			for (int i=1; i<n-(sum-line); i++) {
				a--;
				b++;
			}
		}
		System.out.printf("%d/%d\n", a,b);
	}
}

// 홀수일 때, n/1로 시작
// 짝수일 때, 1/n으로 시작


