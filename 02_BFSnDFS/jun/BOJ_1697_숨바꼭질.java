import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 수빈 위치
		int K = sc.nextInt();	// 동생 위치
		
		int[] visited = new int[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = 0;
		
		while(!queue.isEmpty()) {
			
			// 뽑은 수가 도달하면 결과
			int x = queue.remove();
			if(x == K) {
				System.out.println(visited[x]);
				break;
			}

			// 그다음 이동이 도달하면 결과
			if(x - 1 == K || x + 1 == K || x * 2 == K) {
				System.out.println(visited[x] + 1);
				break;
			}
			
			// 둘다 아니면 다음 이동해서 큐에 삽입 (범위 안에 있으면서)
			if(x != 0 && visited[x - 1] == 0) {
				visited[x - 1] = visited[x] + 1;
				queue.add(x - 1);
			}
			if(x != 100000 && visited[x + 1] == 0) {
				visited[x + 1] = visited[x] + 1;
				queue.add(x + 1);
			}
			if(x * 2 <= 100000 && visited[x * 2] == 0) {
				visited[x * 2] = visited[x] + 1;
				queue.add(x * 2);
			}
			
			// 확인용 출력
//			for(int i = 0; i < K; i++) {
//				System.out.print(visited[i]);
//			}
//			System.out.println();
					
		}
		
		
		
		
	}
}
