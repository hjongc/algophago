import java.util.Scanner;

public class BOJ_10039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for (int i=0; i<5; i++) {
			int tmp = sc.nextInt();
			
			if (tmp < 40) {
				tmp = 40;
			}
			
			sum += tmp;
		}
		System.out.println(sum/5);
		sc.close();
	}

}
