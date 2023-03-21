package day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class BOJ_21939_문제추천시스템Version1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, TreeSet> bst = new TreeMap<Integer, TreeSet>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(st.nextToken()); // 문제번호 
			int L = Integer.parseInt(st.nextToken()); // 문제 난이도
			
			map.put(P, L); // solved를 위해 모든 경우를 맵에 보관한다. 
			
			if (bst.containsKey(L)) {
				// 기존에 존재하는 pq에 값 넣어주기 
				TreeSet<Integer> tmp = bst.get(L);
				tmp.add(P);
				bst.put(L, tmp);
			}
			else {
				TreeSet<Integer> set = new TreeSet<>();
				set.add(P);
				bst.put(L, set);
			}
		}	
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			if (cmd.equals("add")) {
				int P = Integer.parseInt(st.nextToken()); // 문제번호 
				int L = Integer.parseInt(st.nextToken()); // 문제 난이도
				
				map.put(P, L);
				
				if (bst.containsKey(L)) {
					// 기존에 존재하는 pq에 값 넣어주기 
					TreeSet<Integer> tmp = bst.get(L);
					tmp.add(P);
					bst.put(L, tmp);
				}
				else {
					TreeSet<Integer> set = new TreeSet<>();
					set.add(P);
					bst.put(L, set);
				}
			}
			
			else if (cmd.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				
				// 어려운 문제 중 문제 번호가 큰 것 
				if (x==1) {
					int maxKey = bst.lastKey();
					sb.append(bst.get(maxKey).last()).append('\n');
//					if (bst.get(maxKey).size()==0) bst.remove(maxKey);
					
					
				}
				// 쉬운 문제 중 문제 번호가 작은 것 
				else {
					int minKey = bst.firstKey();
					sb.append(bst.get(minKey).first()).append('\n');
					if (bst.get(minKey).size()==0) bst.remove(minKey);
				}
			}
			else if (cmd.equals("solved")) {
				int P = Integer.parseInt(st.nextToken()); // 문제번호 
				
				// 문제번호 P를 제거해야함 
				// map에서 P의 난이도를 가져오고 
				// bst에서 P를 지운다. 	
				int L = map.get(P);
				
				TreeSet<Integer> set = bst.get(L);
				set.remove(P);
				if (set.isEmpty()) {
					bst.remove(L);
				}
				else {
					bst.put(L, set);
				}
			}
		}
		System.out.println(sb);
	}
}
