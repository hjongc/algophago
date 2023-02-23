
import java.util.Scanner;

public class BOJ_2440 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=N; i++) {
			for (int j=N; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}