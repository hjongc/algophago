package day0328;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int N;
	static int cnt;
	static boolean[] col;
	static boolean[] rdiag;
	static boolean[] ldiag;
	static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// NxN 보드 위에 N개의 퀸을 안 겹치게 배열
		N = sc.nextInt();
		cnt = 0;
		
		// 가로 세로는 행과 열을 확인
		//boolean[] row = new boolean[N + 1];
		col = new boolean[N + 1];
		
		// 오른쪽으로 내려가는 대각선
		// r-c = -(n-1) 부터 (n-1)까지 2n-1개
		// (+n) 해서 (1)부터 (2n-1)까지
		rdiag = new boolean[2 * N];
		
		// 왼쪽 아래로 내려가는 대각선
		// r+c = 2부터 2*n까지 2n-1개
		// (-1)해서 (1)부터 (2n-1)까지
		ldiag = new boolean[2 * N];
		
		// 각 행에 어떤 열인지 visited 확인
		visited = new int[N + 1];
		
		// 현재 퀸 1열을 확인해보자
		queen(1);
		
		System.out.println(cnt);
	}
	
	
	// 퀸 확인해서 추가하는 메소드
	// 현재 행, 현재 열, 열체크, 우대각선체크, 좌대각선체크
	public static void queen(int r) {
		// 행 1개에 퀸은 1개만 있을 수 있다
		// 0열부터 맨 뒤까지 퀸 들어갈 수 있는지 확인

		int c = 1;
		while(c <= N) {
			//System.out.println("r :: " + r + " c   " + c);
			// 열 우대각선 좌대각선에 퀸이 없는 열을 찾아서
			// 다음줄로 내려감
			if(!col[c] && !rdiag[r - c + N] && !ldiag[r + c - 1]) {
				// 방문 체크 i행 c열
				visited[r] = c;
				//System.out.println("r : " + r + " / c : " + c);
				col[c] = true;
				rdiag[r - c + N] = true;
				ldiag[r + c - 1] = true;
				
				// 마지막줄이면 cnt하고 뒤에 더 탐색
				if(r == N) {
					cnt++;
					
					// 뒤로 가면 visited 취소
					visited[r] = 0;
					col[c] = false;
					rdiag[r - c + N] = false;
					ldiag[r + c - 1] = false;
					return;
				}
				
				// 열에 넣었으면 다음줄로 내려감
				queen(r + 1);
				// 올라왔으면 원상 복구
				visited[r] = 0;
				col[c] = false;
				rdiag[r - c + N] = false;
				ldiag[r + c - 1] = false;
				
				// 올라왔으면 열 1부터 다시 탐색
				//c = 0; 이걸 하면 계속 같은 퀸의 경우의 수 반복
			}
			
			// 마지막 열 N인데 들어가지 못하고 나왔다면
			// 윗줄로 되돌아감
			if(c == N) {
				// 뒤로 가면 그냥 돌아감
				return;
			}
			// c증가 다음 열 탐색
			c++;
		}
	}
	
}
