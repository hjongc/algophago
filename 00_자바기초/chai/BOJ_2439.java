
import java.util.Scanner;

public class BOJ_2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=N; i++) {
			//怨듬갚�꽔湲�
			for (int j=1; j<=N-i; j++) {
				System.out.print(" ");
			}
			//蹂� �꽔湲�
			for (int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}