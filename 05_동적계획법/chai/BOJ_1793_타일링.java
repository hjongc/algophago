package day0222;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1793_타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger[] dp = new BigInteger[250+1];
		
		for (int i=0; i<=250; i++) {
			// 0을 추가 안하니 실패했다...
			if (i==0) dp[0] = new BigInteger("1");
			else if (i==1) dp[1] = new BigInteger("1");
			else if (i==2) dp[2] = new BigInteger("3");
			else dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
			
		}
		// hasNextInt!!!
		while (sc.hasNextInt()) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
