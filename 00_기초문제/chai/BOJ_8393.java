
import java.util.Scanner;

public class BOJ_8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int sum = 0;
		for (int i=n; i>0; i--) {
			sum += n;
		}
		System.out.println(sum);
	}

}
