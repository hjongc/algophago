import java.util.Scanner;

public class BOJ_25501 {
	public static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			cnt = 0;
			String s = sc.next();
			System.out.printf("%d %d\n", isPalindrome(s), cnt);
		}
	}
	
	public static int recursion(String s, int l, int r){
        cnt++;
		if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
