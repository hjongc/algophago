
import java.util.Scanner;

public class BOJ_11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = sc.next().split("");
		
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			
			if (i%10==9) {
				System.out.println();
			}
		}		
		sc.close();

	}

}
