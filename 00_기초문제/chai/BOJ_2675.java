import java.util.Scanner;

public class BOJ_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for (int i=0; i<t; i++) {
			int r = sc.nextInt();
			String s = sc.next();
			
			// 한문자열씩
			for (int j=0; j<s.length(); j++) {
				// r번 반복
				for (int k=0; k<r; k++) {
					System.out.print(s.charAt(j));	
				}
				
			}
			System.out.println();
		}
		sc.close();
		
	}
}
