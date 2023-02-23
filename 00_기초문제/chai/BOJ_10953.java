import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10953 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			String s = sc.next();
			st = new StringTokenizer(s, ",");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a+b);
			
	
		}
		sc.close();
	}
}
