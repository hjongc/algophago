package day0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> bst = new TreeMap<Integer, Integer>();
			
			for (int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				
				if (cmd.equals("I")) {
					int cmdI = Integer.parseInt(st.nextToken());
					// getOrDefault 없으면 0 넣어주는 듯! 
					bst.put(cmdI, bst.getOrDefault(cmdI, 0)+1);
				}
				// 삭제명령일 때 
				else {
					String cmdD = st.nextToken();
					// 비어있으면 continue 
					if (bst.isEmpty()) continue;
					
					// 최솟값 제거
					if (cmdD.equals("-1")) {
						int minKey = bst.firstKey();
						// 최솟값이 한개만 있는 경우 
						// 바로 삭제해준다. 
						if (bst.get(minKey)==1) bst.remove(minKey);
						
						// 여러개 있는 경우
						// 하나를 줄여준다.
						else {
							bst.replace(minKey, bst.get(minKey)-1);
						}
					}
					// 최댓값 제거 
					else {
						int maxKey = bst.lastKey();
						// 최솟값이 한개만 있는 경우 
						// 바로 삭제해준다. 
						if (bst.get(maxKey)==1) bst.remove(maxKey);
						
						// 여러개 있는 경우
						// 하나를 줄여준다.
						else {
							bst.replace(maxKey, bst.get(maxKey)-1);
						}
					}
				}
			}
			if (bst.isEmpty()) System.out.println("EMPTY");
			else System.out.printf("%d %d\n", bst.lastKey(), bst.firstKey());
		}
	}
}
