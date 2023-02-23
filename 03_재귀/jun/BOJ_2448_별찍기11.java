package 재귀;

import java.util.Scanner;

// BOJ_2448_별찍기11
public class BOJ_2448_별찍기11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// The Math.pow() method returns the value of x to the power of y (xy)
		int n = sc.nextInt();
		// power2 = 2^k (2의 k제곱)
		int power2 = n / 3;
		int k = 0;
		
		for(int i = 0; i <= 10; i++) {
			if(power2 == 1) {
				n = (int) (3 * Math.pow(2,  i));
				k = i;
				break;
			}
			power2 = power2 / 2;
		}
		
		// 삼각형 재귀
		char[][] arr = tri(k);
		
		// 출력
		for(int i = 1; i <= (int)(3 * Math.pow(2, k)); i++) {
			for(int j = 1; j <= (int)(5 * Math.pow(2, k) + Math.pow(2, k) - 1); j++) {
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
	
	
	public static char[][] tri(int k) {
		// k = 0일 때 시작값
		if(k == 0) {
			// 제로인덱스는 헷갈려서 1부터 할 거다
			char[][] arr = {{' ', ' ', ' ', ' ', ' ', ' '},
							{' ', ' ', ' ', '*', ' ', ' '},
							{' ', ' ', '*', ' ', '*', ' '},
							{' ', '*', '*', '*', '*', '*'}};
			return arr;
		}
		
		// 3*2^k일 때 
		// 세로 : 3*2^k 가로 : 5*2^k + (2^k - 1)(사이간격) 
		int row = (int)(3 * Math.pow(2, k));
		int col = (int)(5 * Math.pow(2, k) + Math.pow(2, k) - 1);
		char[][] arr = new char[row + 1][col + 1];

		// k - 1에서 arr을 가져와서
		char[][] arrBefore = tri(--k);
		
		
		// 위쪽 반
		for(int i = 1; i <= row/2; i++) {
			
			// (가로 + 1)/4 비우고
			//for(int j = 1; j <= (col+1)/4; j++) {
			//	arr[i][j] = ' ';
			//}
			
			// arrBefore 넣고
			for(int j = (col+1)/4+1; j < (col+1)/4*3; j++) {
				arr[i][j] = arrBefore[i][j - ((col+1)/4+1) + 1];
			}
			
			// (가로 + 1)/4 비우고
			//for(int j = (col+1)/4*3; j <= col; j++) {
			//	arr[i][j] = ' ';
			//}
		}
		
		
		// 아래쪽 반
		for(int i = row/2+1; i <= row; i++) {
			
			// arrBefore 넣고
			for(int j = 1; j <= (col-1)/2; j++) {
				arr[i][j] = arrBefore[i - (row/2)][j];
			}
			
			// 세로 한 줄 비우고
			//arr[i][(col-1)/2 + 1] = ' ';
			
			// arrBefore 넣고
			for(int j = col/2 + 1; j <= col; j++) {
				arr[i][j] = arrBefore[i - (row/2)][j - (col/2+1)];
			}
		}
		
		
		return arr;
		
	}
}