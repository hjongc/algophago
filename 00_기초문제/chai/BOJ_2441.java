
import java.util.Scanner;

public class BOJ_2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		
		for (int i=0; i<N; i++) {

			//°ø¹é 0,1,2,3,4,5
			for (int j=0; j<i; j++) {
				System.out.print(" ");
			}
				
			//º° 5,4,3,2,1,
			for (int k=N; k>i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
