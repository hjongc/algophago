package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1012번 유기농배추
public class BOJ_1012_유기농배추 {
	// 함수랑 변수 쓸거면 클래스에 변수 선언해야 한다
	private static int width = 0;
	private static int height = 0;
	static boolean[][] visited;
	static boolean[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 

		for(int t = 0; t < T; t++) {
			width = sc.nextInt(); // 가로 길이
			height = sc.nextInt(); // 세로 길이
			int num = sc.nextInt(); // 배추 개수
			int count = 0; // 배추지렁이 개수
			
			// 지도에 배추 심기 (배추 위치 제로인덱스)
			map = new boolean[height][width]; // 행 세로 y 열 가로 x
			for(int i = 0; i < num; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = true;
			}
			
			visited = new boolean[height][width];
			// 탐색은 그냥 지도 전체에서 한다
			for(int i = 0; i < height; i++) { // 세로
				for(int j = 0; j < width; j++) { // 가로
					if(!visited[i][j] && map[i][j]) {
						BFS(i, j);
						count++;
					}
				}
			}
			
			// 배추지렁이 개수 출력 
			System.out.println(count);
		}
	}
	
	
	// BFS 탐색
	static void BFS(int y, int x) {
		// 사방면 방향 설정
		int[] dir_x = {-1, 1, 0, 0};
		int[] dir_y = {0, 0, -1, 1};
		
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {y, x});
		visited[y][x] = true;


		while(!queue.isEmpty()) {
			
			// 다음 큐 요소 주위 탐색
			y = queue.peek()[0]; // peek는 위에서 값만 반환이고
			x = queue.peek()[1]; // poll은 빼면서 반환이다(주의)
			queue.poll();
			
			// 인접한 위치에 체크
			for(int i = 0; i < 4; i++) {
				int xx = x + dir_x[i]; // 새로운 x 좌표
				int yy = y + dir_y[i]; // 새로운 y 좌표
				if(range(yy, xx)) {
					if(!visited[yy][xx] && map[yy][xx]) {
						queue.add(new Integer[] {yy, xx});
						visited[yy][xx] = true;
					}
				}
			}
			
		}
	}
	
	// 좌표가 지도 안에 있는지
	static boolean range(int y, int x) {
		if(x >= 0 && x < width && y >= 0 && y < height) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

