import java.util.Scanner;

public class BOJ_15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String s = sc.next();
		
		int r = 31;
		int m = 1234567891;
		
		long pow = 1;
		long sum = 0;
		for (int i=0; i<l; i++) {
			sum += ((s.charAt(i)-'a'+1) * pow);
			
			pow = pow * r % m;
		}
		System.out.println(sum % m);
	}
}
