package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_5648_역원소정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// n개 숫자 입력
		ArrayList<Long> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			
			// Exception in thread "main" java.lang.NumberFormatException
			// int 범위를 벗어난 숫자를 int로 받아오려해서 에러
			// int 관련 함수들을 다 long으로 바꾼 메서드가 존재한다
			
			// 숫자 입력 받아서 문자로
			long num = sc.nextLong();
			String num_str = String.valueOf(num);
			String num_str_flip = "";
			
			// 숫자 뒤집기
			for(int j = num_str.length() - 1; j >= 0; j--) {
				num_str_flip += String.valueOf(num_str.charAt(j));
			}
			
			long num_flip = Long.parseLong(num_str_flip);
			list.add(num_flip);
		}

		// 정렬
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	
		
	}
}
