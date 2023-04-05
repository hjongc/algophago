import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_5567_결혼식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 상근이 동기의 수(1번 ~ n번)
		int n = sc.nextInt();
		
		// n + 1길이의 배열 안에 요소로 ArrayList<Integer>가 각각 들어있다
		// int[] arr = new int[n];
		// ArrayList<Integer>[] arr = new ArrayList<Integer>[n + 1]; 아님
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		
		// 1번부터 n번까지 ArrayList 선언해서 넣어줌
		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		// 친구 관계 개수
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		// 상근이는 1번이다 : 본인 친구 && 친구의 친구
		// 친구의 친구에서 겹치지 않게 저장
		HashSet<Integer> hs = new HashSet<>();

		// 상근이(1)의 친구 명수를 더해줌 
		for(int i = 0; i < arr[1].size(); i++) {
			hs.add(arr[1].get(i));
		}
		
		// 상근이(1)의 친구의 친구를 찾아줌
		for(int i = 0; i < arr[1].size(); i++) {
			// 상근이의 친구의 친구를 겹치지 않게 넣어줌
			int friend = arr[1].get(i);
			for(int j =0; j < arr[friend].size(); j++) {
				hs.add(arr[friend].get(j));
			}
		}
		
		
		// 해시셋에 상근이(1)도 포함되어 있으면 빼주기
		if(hs.contains(1)) hs.remove(1);
		
		// 해시셋 크기 출력
		System.out.println(hs.size());
	}
}
