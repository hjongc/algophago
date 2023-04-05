package day0404;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 유저의 수
		int N = sc.nextInt();
		
		// 친구 관계 수
		int M = sc.nextInt();
		
		// 친구 관계 입력
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		// 케빈 베이컨 수
		int[] kevinBacon = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			// 친구 체크 했는지 확인
			int[] visited = new int[N + 1];
			
			// 정점까지의 거리를 구하는 큐
			Queue<int[]> queue = new LinkedList<>();
			
			// 본인 정점 삽입
			visited[i] = 1;
			queue.offer(new int[] {i, 0});
			
			while(!queue.isEmpty()) {
				int node = queue.peek()[0];
				int len = queue.poll()[1];
				
				// 연결된 노드로 이동
				for(int j = 1; j <= N; j++) {
					if(arr[node][j] == 1 && visited[j] != 1) {
						visited[j] = 1;
						// 방문했으면 나온 길이 케빈 베이컨에 더해주기
						kevinBacon[i] += len + 1;
						queue.offer(new int[] {j, len + 1});
						
					}
				}
			}
		}
		
		// 케빈 베이컨 수 최솟값 구하고 + 가장 작은 사람중 번호 작은 사람
		int min = kevinBacon[1];
		for(int i = 2; i <= N; i++) {
			if(kevinBacon[i] < min) min = kevinBacon[i];
		}
		for(int i = 1; i <= N; i++) {
			if(kevinBacon[i] == min) {
				System.out.println(i);
				break;
			}
		}
		
		
		
	}
}
