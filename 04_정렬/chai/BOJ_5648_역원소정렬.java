//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5648_역원소정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		long[] arr = new long[n];
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			String reverseS = "";
			
			// 00000000000005일 경우 비효율적임 
			for (int j=s.length()-1; j>=0; j--) {
				reverseS += s.charAt(j);
			}
			
			arr[i] = Long.parseLong(reverseS);
		}
		
		Arrays.sort(arr);
		
		for (int i=0; i<n; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
}
