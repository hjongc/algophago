package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				System.out.println(arr[i]);
			}
			if(i != 0 && !arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}
		
		
	}
}
