package day0222;


import java.util.Scanner;

public class BOJ_1932_정수삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		int[][] arr = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<=i; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 초기값 입력
		arr[0][0] = map[0][0];
		
		// arr에 경로 최댓값 저장하기
		for (int i=1; i<n; i++) {
			for (int j=0; j<=i; j++) {
				// 각 줄의 0번 인덱스일 때
				if (j==0) {
					arr[i][j] = arr[i-1][j] + map[i][j];
					continue;
				}
				// 각 줄의 마지막 인덱스일 때
				if (j==n-1) {
					arr[i][j] = arr[i-1][j-1] + map[i][j];
					continue;
				}
				// 일반적인경우
				// 중복되는 부분이 있는데 그 중 최댓값으로 저장
				arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + map[i][j];
			}
		}
		// arr 마지막 줄에서 최댓값 찾기
		int max = 0;
		for (int i=0; i<n; i++) {
			if (arr[n-1][i] > max) max = arr[n-1][i];
		}
		System.out.println(max);
	}
}

