import java.util.Scanner;

public class BOJ_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// n번 반
		for (int i=0; i<n; i++) {
			// 괄호 순회
			String ps = sc.next();
			int left = 0;
			boolean isPS = true;
			for (int j=0; j<ps.length(); j++) {
				if (ps.charAt(j) == '(') {
					left++;
				}
				else { //오른쪽 괄호일 경우 
					// left가 없는데 right나오는 경우 
					if (left == 0) {
						isPS = false;
						break;
					}
					else {
						left--;
					}
				}
			}
			if (isPS==true && left == 0) System.out.println("YES");
			else System.out.println("NO");
			
		}
		sc.close();
	}
}