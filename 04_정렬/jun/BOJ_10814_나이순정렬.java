package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int N = Integer.parseInt(sc.nextLine());
		// 나이와 이름 담을 배열
		String[][] arr = new String[N][2];

		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String[] input = str.split(" ");
			
			arr[i][0] = input[0]; // 나이
			arr[i][1] = input[1]; // 이름
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
   	 		@Override
   	 		public int compare(String[] s1, String[] s2) {
   	 			// s1이 크면 양수인 경우만 자리 바꿈(0이면 안 바꿈)
   	 			// s2가 크면 음수
   	 			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
   	 		}
   	 	});
   	 	
   	 	for(int i = 0; i < N; i++) {
   	 		System.out.println(arr[i][0] +" "+ arr[i][1]);
   	 	}
		
	}
}
