package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 통과하긴했는데
// 메모리랑 실행시간이 되게 높음... 왤까
// 실행시간 줄이려고 양쪽에서 BFS해봤는데 별로 좋은 결과는 아니었음

public class BOJ_1697_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 입력받기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 두 좌표가 같으면 그냥 종료
		if (N == K) {
			System.out.println(0);
			return;
		}
		
		// 방문했는지 여부를 체크할 해쉬맵
		Map<Integer, Integer> map = new HashMap<>();
		// bfs를 사용하기 위한 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 맵에 방문한 정보를 넣고
		map.put(N, 1);
		map.put(K, -1);
		// 큐에 방문할 정보를 넣고
		queue.offer(N);
		queue.offer(K);
		
		// bfs
		while(!queue.isEmpty()) {
			
			// in : 방문한 좌표
			// inValue : 방문한 좌표에 도달하기까지 걸린 시간
			// inValue > 0 : N이 방문
			// inValue < 0 : K가 방문
			// 둘이 만날때까지
			int in = queue.poll();
			int inValue = map.get(in);
			
			// N이 방문하는 경우
			if (inValue > 0) {
				// 범위 체크
				if (in * 2 < 100001) {
					// 방문 여부 체크
					if (map.containsKey(in * 2)) {
						// K의 방문 -> 종료
						if (map.get(in * 2) < 0) {
							System.out.println(-map.get(in * 2) + inValue -1);
							return;
						}
						// 방문 X 라면 큐에 넣고 다시
					} else {
						map.put(in*2, inValue+1);
						queue.offer(in*2);
					}
				}
				// 나머지 경우도 마찬가지
				if (in + 1 < 100001) {
					if (map.containsKey(in + 1)) {
						if (map.get(in + 1) < 0) {
							System.out.println(-map.get(in + 1) + inValue -1);
							return;
						}
					} else {
						map.put(in+1, inValue+1);
						queue.offer(in+1);
					}
				}
				if (in - 1 >= 0) {
					if (map.containsKey(in - 1)) {
						if (map.get(in - 1) < 0) {
							System.out.println(-map.get(in - 1) + inValue -1);
							return;
						}
					} else {
						map.put(in-1, inValue+1);
						queue.offer(in-1);
					}
				}
			}
			// K 방문의 경우도 마찬가지
			else {
				if (in % 2 == 0 && in > 0) {
					if (map.containsKey(in / 2)) {
						if (map.get(in / 2) > 0) {
							System.out.println(map.get(in / 2) - inValue -1);
							return;
						}
					} else {
						map.put(in/2, inValue-1);
						queue.offer(in/2);
					}
				}
				if (in + 1 < 100001) {
					if (map.containsKey(in + 1)) {
						if (map.get(in + 1) > 0) {
							System.out.println(map.get(in + 1) - inValue -1);
							return;
						}
					} else {
						map.put(in+1, inValue-1);
						queue.offer(in+1);
					}
				}
				if (in - 1 >= 0) {
					if (map.containsKey(in - 1)) {
						if (map.get(in - 1) > 0) {
							System.out.println(map.get(in - 1) - inValue -1);
							return;
						}
					} else {
						map.put(in-1, inValue-1);
						queue.offer(in-1);
					}
				}
			}
		}
	}
}
