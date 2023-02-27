package day0225;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.next(), "-");
		
		int sum = 0;
		int idx = 0;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			
			// -로 한 번 나눈 토큰을 더하기 위해 
			// +로 한 번 더 나누고 더한다. 
			StringTokenizer tmpSt = new StringTokenizer(s, "+");
			int tmpSum = 0;
			while (tmpSt.hasMoreTokens()) {
				tmpSum += Integer.parseInt(tmpSt.nextToken());
			}
			if (idx==0) {
				sum += tmpSum;
				
			}
			else sum -= tmpSum;
			
			idx++;
		}
		System.out.println(sum);
		
	}
}
