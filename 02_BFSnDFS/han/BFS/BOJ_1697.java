package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 초과
// 이유는 모르겟음... 비슷한 코드는 통과되던데

public class Q1697 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<>();
		
		if (N == K) {
			System.out.println(0);
			return;
		} 
		
		int[] start = {N, 1}; 
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int[] polled = queue.poll();
			int position = polled[0];
			int tmpAns = polled[1];
			int doublePosition = position * 2;
			int addPosition = position + 1;
			int subtractPosition = position - 1;
			
			if(doublePosition == K || addPosition == K || subtractPosition == K) {System.out.println(tmpAns); return;}
			if (doublePosition < 100001) {int[] next = {doublePosition, tmpAns+1}; queue.offer(next);}
			if (addPosition < 100001) {int[] next = {addPosition, tmpAns+1}; queue.offer(next);}
			if (subtractPosition >= 0) {int[] next = {subtractPosition, tmpAns+1}; queue.offer(next);}

		}
	}
	
}
