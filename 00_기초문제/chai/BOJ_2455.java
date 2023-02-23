import java.util.Scanner;

public class BOJ_2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cur = 0;
		int max = 0;
		for(int i=0; i<4; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			cur = cur - a + b;
			
			if (cur>max) max = cur;
		}
		
		System.out.println(max);
		sc.close();
	}
}
