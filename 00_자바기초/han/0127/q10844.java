package baek0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10844 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] numbers = new long[10][N+1];
		numbers[1][1] = 1;
		numbers[2][1] = 1;
		numbers[3][1] = 1;
		numbers[4][1] = 1;
		numbers[5][1] = 1;
		numbers[6][1] = 1;
		numbers[7][1] = 1;
		numbers[8][1] = 1;
		numbers[9][1] = 1;
		
		for (int i = 2; i< N+1; i++) {
			numbers[0][i] = numbers[1][i-1] % 1000000000;
			numbers[1][i] = numbers[0][i-1] % 1000000000+ numbers[2][i-1]% 1000000000;
			numbers[2][i] = numbers[1][i-1] % 1000000000+ numbers[3][i-1]% 1000000000;
			numbers[3][i] = numbers[2][i-1] % 1000000000+ numbers[4][i-1]% 1000000000;
			numbers[4][i] = numbers[3][i-1] % 1000000000+ numbers[5][i-1]% 1000000000;
			numbers[5][i] = numbers[4][i-1] % 1000000000+ numbers[6][i-1]% 1000000000;
			numbers[6][i] = numbers[5][i-1] % 1000000000+ numbers[7][i-1]% 1000000000;
			numbers[7][i] = numbers[6][i-1] % 1000000000+ numbers[8][i-1]% 1000000000;
			numbers[8][i] = numbers[7][i-1] % 1000000000+ numbers[9][i-1]% 1000000000;
			numbers[9][i] = numbers[8][i-1] % 1000000000;
		}
		long result = 0;
		for (int i = 0; i<10; i++) {
			result += numbers[i][N]% 1000000000;
		}
		System.out.println((numbers[0][N]+numbers[1][N]+numbers[2][N]+numbers[3][N]+numbers[4][N]+numbers[5][N]+numbers[6][N]+numbers[7][N]+numbers[8][N]+numbers[9][N])%1000000000);
		System.out.println(result%1000000000);
	}
}
