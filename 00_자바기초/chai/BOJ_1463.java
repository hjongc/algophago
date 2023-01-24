import java.util.Scanner;

public class BOJ_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		
		while (x>1) {
			if (x%3==0) {
				x/=3;
				cnt++;
			}
			else {
				x--;
				cnt++;
			}
		
		}
		System.out.println(cnt);
	}
}
