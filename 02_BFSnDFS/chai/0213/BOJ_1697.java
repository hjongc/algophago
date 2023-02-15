import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈 현 위치 
		int K = sc.nextInt(); // 동생 현 위치 
		
		// 100000보다 더 커도 됨 하지만 비효율 
		// -1로 초기화 => visit 안 써도 됨 
		int[] map = new int[100000+1];
		Arrays.fill(map, -1);
		
		
		Deque<Integer> que = new ArrayDeque<>();
		
		que.addLast(N);
		map[N] = 0;
		
		while (map[K] == -1 && !que.isEmpty()) {
			int cur = que.pollFirst();
			
			// 방향도우미 
			int[] dir = new int[] {cur-1, cur+1, cur*2};
			for (int i=0; i<3; i++) {
				
				if (dir[i] < 0 || dir[i]>100000) continue;

				if (map[dir[i]] >= 0) continue;

				
				map[dir[i]] = map[cur]+1;
				que.addLast(dir[i]);
			}
			
			
		}
		System.out.println(map[K]);
	}
}

// [-1, 4, 3, 2, 1, 0, 1, 4, 3, 2, 1, 2, -1, -1, -1, -1, -1, -1, 4, 3, 2, 3
