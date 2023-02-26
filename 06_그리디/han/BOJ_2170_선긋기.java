package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2170_선긋기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// priority queue를 이용하여 시작 점의 위치로, 같다면 완료되는 점의 위치로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) return a[1]-b[1];
			return a[0] - b[0];
		});
		
		// 모든 입력을 priority queue에 집어넣음
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {start,end});
		}
		
		/*
		 * **********************대전제**********************
		 * priority queue는 정렬되어있으며
		 * 시작시간이 빠른 순으로 (만약 같다면 완료시간이 빠른 순으로)
		 * 정렬되어 있다
		 * ************************************************
		 * 
		 * 1. 
		 * 만약 선이 그어지고 있을 때
		 * ( A라는 선분이 점 1 ~ 6까지 그어지고 있음 )
		 * 새로운 선분의 시작지점이 1 , 6 사이에 존재하고
		 * 새로운 선분의 끝나는 지점이 6 보다 크다면
		 * ( B라는 선분이 점 3 ~ 8까지 그어질 예정 )
		 * 
		 * 만들어지는 선은 점 1 ~ 8 까지라고 보아도 된다
		 * 
		 * 2.
		 * 만약 선이 그어지고 있을 때
		 * ( A라는 선분이 점 1 ~ 6까지 그어지고 있음 )
		 * 새로운 선분의 시작지점이 1 , 6 사이에 존재하고
		 * 새로운 선분의 끝나는 지점이 6 보다 작다면
		 * ( B라는 선분이 점 3 ~ 5까지 그어질 예정 )
		 * 
		 * 만들어지는 선은 기존의 선과 같다 ( 1 ~ 6 )
		 * 
		 * 3. 
		 * 그 이외의 경우에서는
		 * 다시 선을 긋기 시작하는것
		 * 
		 * 이를 코드로 나타내면 다음과 같다
		 */
		
		// 맨 처음 선분
		int[] current = pq.poll();
		int start = current[0];
		int end = current[1];
		int sum = 0;
		
		// 다음 선분들
		for (int i = 1; i<N; i++) {
			current = pq.poll();
			int currentStart = current[0];
			int currentEnd = current[1];
			
			// 1번 케이스
			if (start <= currentStart && currentStart <= end) {
				if (currentEnd > end) end = currentEnd;
				
				// 3번 케이스
			} else {
				sum += (end-start);
				start = currentStart;
				end = currentEnd;
			}
		}
		
		sum += (end-start);
		System.out.println(sum);
	}
}
