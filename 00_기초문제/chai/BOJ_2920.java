import java.util.Scanner;

public class BOJ_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isAsc = true;
		boolean isDes = true;
		
		int before = sc.nextInt();
		for (int i=1; i<8; i++) {
			int tmp = sc.nextInt();
			
			if (before > tmp) {
				isAsc = false;
			}
			else {
				isDes = false;
			}
			before = tmp;
		}
		if (isAsc) System.out.println("ascending");
		else if (isDes) System.out.println("descending");
		else System.out.println("mixed");
		sc.close();
	}
}
