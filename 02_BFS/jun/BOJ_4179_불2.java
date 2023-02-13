import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4179_불2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		
		// 지도 + 불 초기 위치 + 지훈이 초기 위치
		int[][] map = new int[row][col];
		int[] firstFire = new int[3];
		int[] firstJihoon = new int[3];
		
		// map에 값 저장 (할 필요는 없네)
		for(int i = 0; i < row; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < col; j++) {
				String ch = String.valueOf(str.charAt(j));
				// 테두리면 -1
				if(ch.equals("#")) {
					map[i][j] = -1;
				}
				
				// 입력 값 받으면서 불 위치 저장
				if(ch.equals("F")) {
					firstFire[0] = i;
					firstFire[1] = j;
					firstFire[2] = 1;
				}

				// 입력 값 받으면서 지훈이 위치 저장
				if(ch.equals("J")) {
					firstJihoon[0] = i;
					firstJihoon[1] = j;
					firstJihoon[2] = 1;
				}
			}
		}
		
		// 델타 2차원 배열 검색
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 탈출시간
		String result = null;
		
		// 불이 퍼져나가는 BFS, 지훈이가 이동하는 BFS
		// 불이 없고 && 지훈이가 있음 -> 없으면 지훈이 죽음
		// 지훈이의 행 또는 열이 rol col을 벗어나면 -> 탈출한 것
		
		
		// 불 초기값, 지훈 초기값 큐에 저장
		Queue<int[]> fireQ = new LinkedList<>();
		fireQ.add(firstFire);
		Queue<int[]> jihoonQ = new LinkedList<>();
		jihoonQ.add(firstJihoon);
		
		// 불 먼저 저장
		while(!fireQ.isEmpty()) {
			// 불 큐에서 빼서 BFS
			int fr = fireQ.peek()[0];
			int fc = fireQ.peek()[1];
			int fn = fireQ.peek()[2];
			fireQ.poll();
			
			// fr 행 fc 열에 fn 초에 불이 붙었다.
			map[fr][fc] = fn;
			
			for(int i = 0; i < 4; i++) {
				int y = fr + dx[i];
				int x = fc + dy[i];
				int n = fn + 1;
				// n은 지난 시간이다. 큐를 한 번 통과할 때마다 증가한다.
				
				// 범위 안에 있고
				if(y >= 0 && y < row && x >= 0 && x < col) {
					// 벽이 아니다 -1이 아니다.
					//if(fire[y][x] == 0 && fire[y][x] != -1) {
					if(map[y][x] == 0) {
						fireQ.add(new int[] {y, x, n});
					}
				}
				
			}
		}
		
		
		// 확인용 불 출력
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		while(!jihoonQ.isEmpty()) {
			// 지훈 큐에서 빼서 BFS
			int jr = jihoonQ.peek()[0];
			int jc = jihoonQ.peek()[1];
			int jn = jihoonQ.peek()[2];
			jihoonQ.poll();
			
			// jr 행 jc 열에 jn 초에 지훈이가 위치함
			map[jr][jc] = jn;
			
			for(int i = 0; i < 4; i++) {
				int y = jr + dx[i];
				int x = jc + dy[i];
				int n = jn + 1;
				
				// 행렬 범위를 벗어났으면 통과
				if(y < 0 || y >= row || x < 0 || x >= col) {
					// 이동 전 시간
					result = String.valueOf(n - 1);
					break;
				}

				// 범위 안에 있고
				// 이동하려는 곳에 불이 없고 && 벽이 없다면 큐에 추가
				if(y >= 0 && y < row && x >= 0 && x < col) {
					// 이동하려는 곳의 불 붙은 시간이 현재 시간 이후라면(크다면) || 불이 없다면
					// 이동하려는 곳에 불이 없고 && 벽이 없고(-1이 아니고) && 지훈이가 온 적이 없다면 큐에 추가
					if(map[y][x] == 0 || map[y][x] > n) {
						jihoonQ.add(new int[] {y, x, n});
					}
				}
				
				
			}
		}
		
		
		// 확인용 지훈 출력
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		
		if(result == null) {
			// 통과하지 못하고 끝난다면 탈출 불가능
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
		
		
	}
}