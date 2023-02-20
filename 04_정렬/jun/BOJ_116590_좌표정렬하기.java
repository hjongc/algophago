package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_116590_좌표정렬하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			// x좌표, y좌표
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// Arrays.sort에서 Comparator 인터페이스 사용
		// 익명클래스로 Comparator 생성
		// 이차원 배열이면 int[] 일차원 배열이면 int 넣어줌
		Arrays.sort(arr, new Comparator<int[]>() {

			// compareTo
			// return 값
			// - 양수 : 자리를 바꿈
			// - 음수 : 그대로
			// - 0 : 그대로
			
			// 현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
			// 현재 객체 == 파라미터로 넘어온 객체: 0 리턴
			// 현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
			// 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
	}
	
	
	
}
