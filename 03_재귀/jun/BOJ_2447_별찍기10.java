package 재귀;

import java.util.Scanner;

public class BOJ_2447_별찍기10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int k = 0;
		
		for(int i = 1; i < 8; i++) {
			// 3으로 1번 나눴는데 1되면 1승
			n = n / 3;
			k++;
			if(n == 1) {
				break;
			}
		}
		
		// 삼각형 재귀
		char[][] arr = star(k);
		
		// 출력
		for(int i = 1; i <= (int)Math.pow(3, k); i++) {
			for(int j = 1; j <= (int)Math.pow(3, k); j++) {
				// 값이 들어가지 않았으면 빈칸 출력
				if(arr[i][j] == '\u0000') {
					sb.append(" ");
				} else {
					sb.append(arr[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	
	public static char[][] star(int k) {
		// k = 0일 때 시작값
		if(k == 1) {
			// 제로인덱스는 헷갈려서 1부터 할 거다
			char[][] arr = {{' ', ' ', ' ', ' '},
							{' ', '*', '*', '*'},
							{' ', '*', ' ', '*'},
							{' ', '*', '*', '*'}};
			return arr;
		}
		
		// 가로 세로길이 3^k
		int width = (int)Math.pow(3, k);
		char[][] arr = new char[width + 1][width + 1];

		// k - 1에서 arr을 가져와서
		char[][] arrBefore = star(--k);
		
		// 9등분으로 나눠서 가운데 제외 before로 채운다
		// 위에서 첫 번째
		for(int i = 1; i <= width/3; i++) {
			for(int j = 1; j <= width; j++) {
				if(j % (width/3) == 0) {
					arr[i][j] = arrBefore[i][width/3];
				} else {
					arr[i][j] = arrBefore[i][j % (width/3)];
				}
			}
		}
		
		// 위에서 두 번째
		for(int i = width/3 + 1; i <= width/3*2; i++) {
			for(int j = 1; j <= width/3; j++) {
				if(j % (width/3) == 0) {
					arr[i][j] = arrBefore[i - width/3][width/3];
				} else {
					arr[i][j] = arrBefore[i - width/3][j % (width/3)];
				}
			}
			// 가운데는 입력 안 함
			for(int j = width/3*2 + 1; j <= width; j++) {
				if(j % (width/3) == 0) {
					arr[i][j] = arrBefore[i - width/3][width/3];
				} else {
					arr[i][j] = arrBefore[i - width/3][j % (width/3)];
				}
			}
		}
		
		// 위에서 세 번째
		for(int i = width/3*2 + 1; i <= width; i++) {
			for(int j = 1; j <= width; j++) {
				if(j % (width/3) == 0) {
					arr[i][j] = arrBefore[i - width/3*2][width/3];
				} else {
					arr[i][j] = arrBefore[i - width/3*2][j % (width/3)];
				}
			}
		}
		
		return arr;
		
	}
}