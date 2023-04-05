package day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
	static int N;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		// 이렇게 그래프 하나하나 출력하면 당연히 시간초과나지 !
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 정점의 개수 N, N개의 줄에 인접 행렬
		N = Integer.parseInt(br.readLine());
		
		// 간선 표현
		arr = new ArrayList[N];
		
		// 각각의 노드에 ArrayList 생성해서 넣어줌
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 간선 입력 받아서 넣어줌
		// 방향 그래프여서 쌍방으로 넣어주지 않는다
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					// i에서 j로 가는 간선이 있다
					arr[i].add(j);
				}
			}
		}
		
		// i에서 j로 가는 경로가 있는지
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// move : i에 연결된 정점들로 이동
				// move(i)라는 건 i로 이동한다는 뜻
				// i로 이동할 때까지 간선 개수 line개
				if(move(i, j, i, 0)) sb.append("1 ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	// 이 메서드에서 st에 연결된 곳으로 이동한다
	// st에서 출발할 때 line 
	// 출발점, 도착점, 현재지점, 이동한 간선 갯수
	public static boolean move(int st, int ed, int curr, int line) {
		
		// 종료지점 확인
		// 이동했더니 도착점이면
		if(line > 0 && curr == ed) return true;
		
		// 간선을 다 확인했으면
		if(line == N) return false;
		
		// 이동했더니 출발점으로 다시 돌아왔으면
		if(line > 0 && curr == st) return false;
		
		// 정점 이동
		// 시작점에 연결된 노드가 있다면 연결
		if(arr[curr].size() > 0) {
			// 0번부터 N-1번까지 정점으로 이동
			for(int i = 0; i < N; i++) {
				// 정점 i에 연결이 되어 있으면 이동
				// 간선 한 개 더 이동하니까 line++
				if(arr[curr].contains(i)) {
					
					// 이동해서 돌아온다음
					// 리턴값 전달하기
					if(move(st, ed, i, line +1)) return true;
					
					// true가 아니어서 도착하지 않았다면
					// for문에 다음 정점 확인하러 가기
				}
			}
		}
		
		// 정점 다 확인했는데도 도착하지 못하고
		// 더이상 이동할 정점 없어서 for문을 나왔다면
		return false;
	}
}
