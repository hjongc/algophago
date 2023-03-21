package day0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_23326_홍익투어리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int isM = Integer.parseInt(st.nextToken());
			// 명소인 경우에만 트리맵에 입력한다. 
			if (isM==1) set.add(i);
		}
		StringBuilder sb = new StringBuilder();
		
		int cur = 0; // 도현이의 위치 
		for (int q=0; q<Q; q++) {
//			System.out.println(set.toString());
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd==1) {
				int i = Integer.parseInt(st.nextToken());
				
				// map에서 해당 위치가 명소인지 확인(트리맵에 존재하는 지 확인)
				// 명소이면 트리맵에서 지운다.
				// 명소가 아니면 트리맵에 입력해준다.
				if (set.contains(i-1)) set.remove(i-1);
				else set.add(i-1);
				
			}else if (cmd==2) {
				// 도현이가 x만큼 이동한다.
				int x = Integer.parseInt(st.nextToken());
				cur = (cur+x)%N;
				
			}else if (cmd==3) {
				// 명소에 도달하기 위해 시계방향으로 몇 칸 이동?
				// 명소 존재하지 않으면 -1 
				if (set.isEmpty()) sb.append(-1).append('\n');
				// 현위치가 명소일 때 
				else if (set.contains(cur)) sb.append(0).append('\n');
				else {
					// 더 큰 명소가 있을 때
					// ex) cur=3 -> 다음 명소 5
					if (set.higher(cur)!=null) {
						sb.append(set.higher(cur)-cur).append('\n');
					}
					// 현재 위치보다 작은 곳에 다음 명소가 있을 때
					else {
						// 전체 길이 - 현재위치 + 가장 첫 번째 명소
						int tmp = (N - cur + set.first());
						sb.append(tmp).append('\n');
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}
