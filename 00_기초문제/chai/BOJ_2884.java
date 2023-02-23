import java.util.Scanner;

public class BOJ_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h =  sc.nextInt();
		int m = sc.nextInt();
		
		int tmp = h*60 + m;
		int newTmp = tmp-45;
		
		if (newTmp < 0) {
			h = 23;
			m = 60+newTmp;
		}
		
		else {
			h = newTmp/60;
			m = newTmp%60;
		}
		
		System.out.printf("%d %d",h,m);
	}
}
