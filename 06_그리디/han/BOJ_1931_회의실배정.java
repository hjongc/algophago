package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// priority queue를 이용하여 시작시간순으로 정렬, 같다면 완료시간 순으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) return o1[1]-o2[1];
			else return o1[0] - o2[0];
		});
		
		// 모든 입력을 priority queue에 넣어서 정렬하겠다
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {start,end});
		}
		
		/*
		 * -- 대전제 --
		 * priority queue는 정렬되어있으며
		 * 시작순서이 빠른 순으로 (만약 같다면 완료시간이 빠른 순으로)
		 * 정렬되어 있다
		 * -----------
		 * 
		 * 1. 
		 * 현재 회의실을 사용하고 있는 회의의 완료시간이
		 * priority queue에 있는 원소의 시작시간보다 빠르다면
		 * priority queue에 있는 모든 원소보다 시작시간이 빠른것
		 * 따라서 현재 회의를 마칠때까지 다른 회의와 겹치지 않으므로
		 * 회의실은 사용가능하다
		 * 
		 * 2. 
		 * 그 이외의 경우에서
		 * 만약 회의실을 사용하고 있는 회의(A)의 완료시간이
		 * priority queue에 있는 회의(B)의 완료시간보다 느리다면
		 * 지금 회의를 쓰고있는 애들을 내쫓고
		 * priority queue에 있는 애들이 회의실을 사용하는게 더 좋다
		 * (왜냐하면, B는 항상 A보다 먼저 끝나므로 B가 사용하게 하는것이 더 많이 사용할 수 있는 방법이다)
		 * 
		 * 이를 코드로 나타내면 다음과 같다
		 */
		int start = 0;
		int end = Integer.MAX_VALUE;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			int[] out = pq.poll();
			int currentStart = out[0];
			int currentEnd = out[1];
			
			if (end <= currentStart) {
				cnt++;
				start = currentStart;
				end = currentEnd;
			} else if (currentEnd < end) {
				start = currentStart;
				end = currentEnd;
			} 
		}
		System.out.println(cnt+1);
	}
}
