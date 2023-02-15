import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2450 {
	
	// 배열 전역으로 선언
	static char[][] starOut;
	
	public static void main(String[] args) throws IOException {
		
		// 입출력 선언
		// 시간초과에 시달려서 bufferedWriter까지 사용해봄
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 찍어야 하는 별의 크기 N 를 받아서 배열 선언, char로 선언해줌
		int N = Integer.parseInt(br.readLine());
		starOut = new char[N][N];
		
		// 배열의 모든 원소에 대해서 별 찍는 Star 메서드 실행
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				Star(N, i, j);
			}
		}
		
		// 출력, 아무것도 하지 않은 경우
		// null 문자가 들어가있으므로 이를 공백문자인 ' ' 으로 수정해서 출력해야함
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				if (starOut[i][j] == '\u0000') {bw.write(' '); continue;}
				bw.write(starOut[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		
	}
	
	// 별 찍는 메서드 Star
	public static void Star(int N, int x, int y) {
		
		// 기본 값 N = 1일때 , 별찍기
		if (N == 1) {starOut[x][y] = '*'; return;}
		
		/*
		 N이 1이 아닌 경우는 세 가지로 나뉜다
		 별이 찍힐 큰 종이를 생각해보자. 이를 3x3 영역으로 나눈다
		 
		 	1	|	2	|	3
		 	4	|	5	|	6
		 	7	|	8	|	9
		
		1번 영역은 N/3과 동일하므로 재귀 호출한다
		5번 영역은 아무것도 찍지 않는다
		2, 3, 4, 6, 7, 8, 9번 영역은 1번 영역과 동일하게 찍으면 된다
		 */
		else {
			// 5번 영역 : 아무것도 쓰지 않는다
			if (x >= N/3 && x < 2*N/3 && y >= N/3 && y < 2*N/3){
				return;
			// 2, 3, 4, 6, 7, 8, 9번 영역 : 1번영역의 값을 사용한다
			} else if (x >= N/3 || y >= N/3) {
				starOut[x][y] = starOut[x%(N/3)][y%(N/3)];
				return;
			// 1번 영역 : N/3을 재귀 호출한다
			} else {
				Star(N/3, x%(N/3), y%(N/3));
				return;
			}
		}
	}
}
