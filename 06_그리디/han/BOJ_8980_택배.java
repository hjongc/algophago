package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8980_택배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int villageNum = Integer.parseInt(st.nextToken());
		int maxLoad = Integer.parseInt(st.nextToken());
		
		int complete = 0;
		int nowLoading = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) return a[1]-b[1];
			return a[0] - b[0];
		});
		
		int[] Arr = new int[villageNum+1];
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int load = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {start, end, load});
		}
		
		for (int i = 1; i<=villageNum; i++) {
			complete += Arr[i];
			nowLoading -= Arr[i];
			
			while (!pq.isEmpty() && pq.peek()[0] == i) {
				int[] out = pq.poll();
				if (out[2] < maxLoad-nowLoading) {
					Arr[out[1]] += out[2];
					nowLoading += out[2];
				}
				else {
					Arr[out[1]] += (maxLoad-nowLoading);
					out[2]-= (maxLoad-nowLoading);
					nowLoading = maxLoad;
					for (int j = villageNum; j> out[1]; j--) {
						if (out[2] == 0) break;
						else if (Arr[j] > out[2]) {
							Arr[j] -= out[2];
							Arr[out[1]] += out[2];
							break;
						} else if (Arr[j] >= 0){
							Arr[out[1]] += Arr[j];
							out[2] -= Arr[j];
							Arr[j] = 0;
						}
					}
				}
			}
		}
		System.out.println(complete);
	}
}
