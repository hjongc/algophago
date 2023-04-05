package day0404;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5214_환승 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 역의 수 N개
		// 1번 역에서 N번 역으로 가는데 방문하는 최소 역 개수
		int N = sc.nextInt();

		// 하이퍼튜브 M개
		// 하이퍼튜브 하나는 역 K개를 서로 연결한다
		int K = sc.nextInt();
		int M = sc.nextInt();

		// 연결되어 있는 역
		int[][] arr = new int[N + 1][N + 1];
		
		// 하이퍼튜브가 연결하는 역의 정보
		for(int i = 0; i < M; i++) {
			int[] hyper = new int[K];
			for(int j = 0; j < K; j++) {
				hyper[j] = sc.nextInt();
			}
			
			// 같은 하이퍼 튜브 안에 있다는 건
			// 연결되어 있다는 뜻 (2개씩 조합)
			for(int j = 0; j < K - 1; j++) {
				for(int k = j + 1; k < K; k++) {
					// 이때 j랑 k는 연결되어 있음
					arr[hyper[j]][hyper[k]] = 1;
					arr[hyper[k]][hyper[j]] = 1;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			//System.out.println(Arrays.toString(arr[i]));
		}
		
		// 이렇게 역이 연결되어 있을 때
		// 1에서 N까지 가는 최솟값
		
		// 1에서 시작
		int[] visited = new int[N + 1];
		visited[1] = 1;
		int min = N;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1, 1});
		
		while(!queue.isEmpty()) {
			int node = queue.peek()[0];
			int len = queue.poll()[1];
			//System.out.println("node " + node + " len " + len);
			
			// 최솟값을 넘겼다면 돌아가기
			if(len > min) continue;
			
			// 도착했다면 최솟값 갱신
			if(node == N) {
				if(len < min) min = len;
			}
			
			// 인접하는 노드들 방문
			for(int i = 1; i <= N; i++) {
				if(arr[node][i] == 1) {
					queue.offer(new int[] {i, len + 1});
				}
			}
		}
		
		System.out.println(min);
	}
}
