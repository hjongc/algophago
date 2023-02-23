import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[n+1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			ArrayList<Integer> tmpList = new ArrayList<>();
			
			if(i%3 == 0) {
				tmpList.add(dp[i/3]);
			}
			if(i%2 == 0) {
				tmpList.add(dp[i/2]);
			}
			tmpList.add(dp[i-1]);
			
			dp[i] = Collections.min(tmpList)+1;
		}
		
		System.out.println(dp[n]);
	}
}
