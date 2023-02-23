import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		int cnt= s.length(); 
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			
			if (cur == '-' || cur == '=') cnt--;
			else if (cur == 'd') { // dz=인 경우 
				if (i+2<s.length() && s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
					cnt--;
				}
			}
			else if (cur == 'l' || cur =='n') {// lj, nj인 경우 
				if (i+1<s.length() && s.charAt(i+1)=='j') {
					cnt--;
				}
			}
	
			
		}
		System.out.println(cnt);
	}

}
