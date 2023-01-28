
import java.util.Scanner;

public class BOJ_10871 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		sc.close();
		for (int i=0; i<N; i++) {
			int Y = sc.nextInt();
			if (X > Y) {
				System.out.printf("%d ", Y);
			}
		}
	}

}
