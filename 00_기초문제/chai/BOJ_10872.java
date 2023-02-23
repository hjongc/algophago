import java.util.Scanner;

public class BOJ_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n==0) {
			System.out.println(1);
			return;
		}
		
		long m = 1;
		for (int i=n; i>0; i--) {
			m *=i;
			
		}
		System.out.println(m);
	}
}
