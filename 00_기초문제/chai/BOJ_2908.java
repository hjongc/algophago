import java.util.Scanner;

public class BOJ_2908 {
	
	public static int reverse(int n){
		int newN = 0;
		while (n!=0) {
			newN = newN*10 + n%10;
			n/=10;
		}
		return newN;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if (reverse(x) > reverse(y)) System.out.println(reverse(x));
		else System.out.println(reverse(y));
		sc.close();
	}
}
