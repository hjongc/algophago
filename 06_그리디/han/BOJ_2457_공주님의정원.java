package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2457_공주님의정원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) return o1[1]-o2[1];
			else return o1[0] - o2[0];
		});
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {40*a+b, 40*c+d});
		}
		
		int start = 0;
		int end = 121;
		int cnt = 0;
		
		
		while(!pq.isEmpty() && pq.peek()[0] <= 121) {
			int[] out = pq.poll();
			if (out[1] > end) {
				start = out[0];
				end = out[1];
			}
		}
		if (start == 0) {
			System.out.println(0);
			return;
		}
		cnt++;
		
		while(end < 471) {
			int tmpStart = start;
			int tmpEnd = end;
			while(!pq.isEmpty() && pq.peek()[0] <= end) {
				int[] out = pq.poll();
				if (out[1] > tmpEnd) {
					tmpStart = out[0];
					tmpEnd = out[1];
				}
			}
			start = tmpStart;
			end = tmpEnd;
			cnt++;
			if (pq.isEmpty() && end < 471) {
				System.out.println(0);
				return;
			} else if (!pq.isEmpty() && pq.peek()[0] > end && end < 470) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(cnt);
	}
}
