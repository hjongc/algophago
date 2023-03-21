package day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_1202_보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			// 0에는 가격, 1에는 무게
			// [가격, 무게]
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		// 
		
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0]-o1[0];
			}
			
		});
		
		
		// 가방 담을 트리맵
		TreeMap<Integer, Integer> bags = new TreeMap<Integer, Integer>();
		
		for (int i=0; i<K; i++) {
			int bag = Integer.parseInt(br.readLine());
			if (bags.containsKey(bag)) {
				int sameBagCnt = bags.get(bag);
				bags.replace(bag, sameBagCnt+1);
			}
			else {
				bags.put(bag, 1);
			}
		}
		
		long sum = 0;
		
		for (int i=0; i<N; i++) {
			if (bags.ceilingKey(arr[i][1]) != null) {
				int curKey = bags.ceilingKey(arr[i][1]);
				sum += arr[i][0];
				if (bags.get(curKey)-1 == 0) bags.remove(curKey);
				else bags.replace(curKey, bags.get(curKey)-1);
			}

		}
		System.out.println(sum);
		
	}
}
