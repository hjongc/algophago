package day0404;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2660_회장뽑기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 0명 건너서 모두 친구면 1점 (간선 1개)
		// 1명 건너서 모두 친구면 2점 (간선 2개)
		// 2명 건너서 모두 침구면 3점 (간선 3개)
		// 점수가 작은 사람이 회장
		
		// 회원수 + 회원 간선 입력
		int N = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == -1) break;
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		// 친구 연결 점수
		int[] score = new int[N + 1];
		// 한명씩 확인
		for(int i = 1; i <= N; i++) {
			// 방문했는지
			int[] visited = new int[N + 1];

			// 큐에 넣어서 가까운 것부터 방문
			// 방문한 노드 + 이동횟수 전달
			Queue<int[]> queue = new LinkedList<int[]>();
			
			// 본인 노드 방문
			visited[i] = 1;
			queue.offer(new int[] {i, 0});
			
			// 한번 방문할 때는 +1
			while(!queue.isEmpty()) {
				// 큐에서 꺼내서
				int node = queue.peek()[0];				
				int len = queue.poll()[1];
				score[i] = len;
				
				// 인접 정점 방문
				for(int j = 1; j <= N; j++) {
					if(arr[node][j] == 1 && visited[j] != 1) {
						visited[j] = 1;
						queue.offer(new int[] {j, len + 1});
					}
				}
			}
		}
		
		// 최소 점수 구하기
		int min = N;
		for(int i = 1; i <= N; i++) {
			if(score[i] < min) min = score[i];
		}
		// 회장 후보 명수
		int cnt = 0;
		
		// 최소 점수 가진 회장 후보 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(score[i] == min) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(min + " " + cnt + "\n" + sb);
	}
}
