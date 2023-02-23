import java.util.Scanner;


public class BOJ_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String check = sc.next();
		while (Integer.parseInt(check) != 0) {
			String reversed = "";
			for (int i=check.length()-1; i >= 0; i--) {
				reversed = reversed+check.charAt(i);
			}
			
			if (check.equals(reversed)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
			check = sc.next();
		}
	}
}
