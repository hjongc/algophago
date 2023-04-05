import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1260번 DFS와 BFS
public class BOJ_1260_DFS와BFS {
	// 함수를 쓸거면 클래스에 변수 선언해야 한다
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int V = sc.nextInt(); // 탐색 시작할 정점의 번호
		
		// 배열을 선언하는데
		// 배열 자료형이 int String 아니라 ArrayList<Integer>
		// N길이의 배열 안에 요소로 ArrayList<Integer>가 들어있다
		arr = new ArrayList[N + 1];
		
		// 각각의 노드에 ArrayList 선언
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 각각 노드에 연결 변호 추가
		for(int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			// 간선 갯수 5개면 5개만 주어진다
			// (1-2)면 1에도 추가하고 2에도 추가해야한다
			arr[node1].add(node2);
			arr[node2].add(node1);
		}
		
		
		
		// 각각 노드에서 번호 작은 순서대로 방문해야한다.
		for(int i = 1; i <= N; i++) {
			// arr배열 안에 해당 노드 연결된 숫자가 ArrayList로 들어있으니까
			Collections.sort(arr[i]);
		}

		// 방문한 배열 초기화
		visited = new boolean[N + 1];
		// DFS 결과 출력
		DFS(V);
		System.out.println();
		
		// 방문한 배열 초기화
		visited = new boolean[N + 1];
		// BFS 결과 출력
		BFS(V);
		
	}
	
	// DFS 깊이 우선 탐색 
	public static void DFS(int node) {
		// 방문한 노드 출력하고 방문했음으로 상태 변경
		System.out.print(node + " ");
		visited[node] = true;
		
		// arr[현재노드] 안에는 연결되어 있는 노드 숫자가 ArrayList로 들어있다
		// 연결되어 있는 숫자를 작은 숫자부터 체크
		for(int i : arr[node]) {
			// 방문 안했으면 노드 이동 DFS 다시 호출
			// 만약 다 방문해서 true면 DFS 재귀 안하고 빠져나감
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
	
	
	// BFS 너비 우선 탐색
	public static void BFS(int node) {
		// 방문해야하는 노드 저장 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 첫방문 노드 큐에 넣기 : 큐에 넣는다는 건 방문할 거라는거니까 true
		visited[node] = true;
		queue.add(node);

		// 큐가 비어있을 때까지 실행
		while(queue.isEmpty() == false) {
			// 현재 큐 확인하고 poll해서 프린트
			node = queue.poll();
			System.out.print(node + " ");
			
			// 현재 노드랑 연결되어 있는 노드 체크하면서
			// 그 다음 깊이 인접한 것들을 큐에 삽입하고 넘어감
			for(int i : arr[node]) {
				// 그 노드 방문했으면 - 방문하지 않은 노드를 큐에 삽입
				
				// 2 - 1 - 3
				// 2 	   |
				// 2 ----- 4
				// 2로 시작하면 1, 4를 방문할거니까 true로 바꾸고 큐에 삽입
				// 1을 먼저 넣었으니까 1에 방문해서
				// 1에 연결된 3을 다음 방문하겠다고 큐에 삽입
				// 하지만 다음 방문하는 건 아까 넣어둔 4니까 4먼저 poll하고 방문
				// 4에 방문해서 4에 연결된 3을 넣고 싶지만
				// 아까 방문하겠다는 의미로 true로 바꾸고 큐에 넣었으니까 더 추가 못한다
				// 하지만 다음 방문하는 건 아까 넣어둔 3이니까 3방문
				
				// 해당 노드가 비어있으면
				// 큐에 넣는다는 건 방문한다는 의미니까 true로 바꿔주고 삽입
				if(visited[i] == false) {
					visited[i] = true;
					queue.add(i);
					//System.out.println("큐 " + queue);
				}
			}
			
		}
	}		
	
	
	
}

