package day0311;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		Set<String> set = new HashSet<String>();
		for (int i=0; i<S.length(); i++) {
			String tmp = "";
			for (int j=i; j<S.length(); j++) {
				tmp += S.charAt(j);
				set.add(tmp);
			}
		}
		System.out.println(set.size());
	}
}
