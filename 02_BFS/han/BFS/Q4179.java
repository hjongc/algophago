package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
실패했던거
큐 두개 사용 -> 메모리초과
걍 로직 잘못짜서 F에 지워지는 형태인데도 일단탈출 
3 3
###
#J.
#.F
cnt를 F->J일 때만 체크해서 F없을 때 -> 1나와서 오류
*/

public class Q4179{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 입력받기
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[R][C];
		
		int Jx, Jy;
		Jx = 0;
		Jy = 0;
		
		// 덱으로 선언 ( J를 앞에 넣고 싶어서 )
		Deque<int[]> queue = new ArrayDeque<int[]>();
		
		// 입력을 받고 J의 첫 위치를 Jx Jy에 저장
		for (int i = 0; i<R; i++) {
			String str = br.readLine();
			for (int j = 0; j<C; j++) {
				grid[i][j] = str.charAt(j);
				if (grid[i][j] == 'F') {
					int[] xy = {i, j};
					queue.offer(xy);
				} else if (grid[i][j] == 'J') {
					Jx = i;
					Jy = j;
				}
			}
		}
		
		// { A , B , C } 
		// A : x좌표
		// B : y좌표
		// C : 탈출하는데 걸린 시간
		// J 시작위치를 덱에 넣고 BFS 출발~
		int[] Jstart = {Jx,Jy,1};
		queue.push(Jstart);
		
		// 출발~
		do {
			// 큐에서 뽑아 옴
			// x : x좌표
			// y : y좌표
			int[] position = queue.poll();
			int x = position[0];
			int y = position[1];
			
			// 뽑은게 J
			// 상화좌우 체크
			// 나올 수 있으면 -> 나옴
			// 나올 수 없으면 -> 다음 위치를 큐에 넣고 탈출하는데 걸린시간 하나 더 크게
			if (grid[x][y] == 'J') {
				if (x == 0 || x == R-1 || y == 0 || y == C-1) {System.out.println(position[2]); return;}
				if (x>0 && grid[x-1][y]=='.') {
					grid[x-1][y] = 'J';
					{int[] next = {x-1,y,position[2]+1}; queue.offer(next); }
				}
				if (x<R-1 && grid[x+1][y]=='.') {
					grid[x+1][y] = 'J';
					{int[] next = {x+1,y,position[2]+1}; queue.offer(next);}
				}
				if (y>0 && grid[x][y-1]=='.') {
					grid[x][y-1] = 'J';
					{int[] next = {x,y-1,position[2]+1}; queue.offer(next);}
				}
				if (y<C-1 && grid[x][y+1]=='.') {
					grid[x][y+1] = 'J';
					{int[] next = {x,y+1,position[2]+1}; queue.offer(next);}
				}
			} 
			// 뽑은게 F
			// 상하좌우 체크
			// 얘는 J를 덮어 쓸 수도 있음
			else {
				if (x>0 && grid[x-1][y] != '#' && grid[x-1][y] != 'F') {
					grid[x-1][y] = 'F';
					int[] next = {x-1,y}; 
					queue.offer(next);
				}
				if (x<R-1 && grid[x+1][y] != '#' && grid[x+1][y] != 'F') {
					grid[x+1][y] = 'F';
					int[] next = {x+1,y}; 
					queue.offer(next);
				}
				if (y>0 && grid[x][y-1] != '#' && grid[x][y-1] != 'F') {
					grid[x][y-1] = 'F';
					int[] next = {x,y-1};
					queue.offer(next);
				}
				if (y<C-1 && grid[x][y+1] != '#' && grid[x][y+1] != 'F') {
					grid[x][y+1] = 'F';
					int[] next = {x,y+1};
					queue.offer(next);
				}
			} 
		} while(!queue.isEmpty());
		
		// 큐를 끝까지 뽑았는데도 리턴 못만남 : 불가능 
		System.out.println("IMPOSSIBLE");
	}
}
