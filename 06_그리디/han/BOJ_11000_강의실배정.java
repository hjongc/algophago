package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 다시보니 첫 pq에서 두번째 원소까지 비교할 필요는 없고
		
		// priority queue말고 array로도 될 것 같다
		// 대신 정렬을 NlogN이 걸리는 알고리즘을 쓰고
		// 삽입을 이진탐색을 이용해서 logN만에 실행하면 더 빠를것같다
		PriorityQueue<int[]> in = new PriorityQueue<>((o1,o2) ->{
			if (o1[0] == o2[0]) return o1[1]-o2[1];
			else return o1[0]-o2[0];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o1-o2;
		});
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			in.offer(new int[] {start,end});
		}
		
		for (int i = 0; i<N; i++) {
			int[] out = in.poll();
			int start = out[0];
			int end = out[1];
			
			if(!pq.isEmpty() && pq.peek() <= start) {
				int tmp = pq.poll();
				tmp = end;
				pq.offer(tmp);
			} else {
				pq.offer(end);
			}
		}
		System.out.println(pq.size());
	}
}
