package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		/*
		 * Map 에 ( key, value ) 로 ( 해당숫자, 등장횟수 ) 를 집어넣고
		 * 
		 * for문을 두개 돌면서 i + j 가 Map에 있는지 확인
		 * Map에 있다면 ( 등장횟수 )만큼의 숫자를 만들 수 있다는 것이므로 그만큼 +
		 * 
		 * 근데, 만약 
		 * 0이 2개 있는데 0+0으로 0을 만들었다면 ?
		 * 만든게 아님! 
		 * 0이 3개 있는데 0+0으로 0을 만들었다면 ?
		 * 만든게 맞음! ( 등장횟수 : 3 )
		 * 
		 * 왜 이런일이 발생 ?
		 * i + j로 k를 만들었을 때, i와 k가 겹치거나 j와 k가 겹치는데
		 * i또는 j의 등장횟수가 부족하다면, 만드는데 쓴것이므로 만든게 아님..(스터디떄 자세하게 설명)\
		 * 그래서 check라는 추가 변수를 둠
		 */
		int[] numbers = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i<N; i++) {
			int in = Integer.parseInt(st.nextToken());
			numbers[i] = in;
			if (!map.containsKey(in)) map.put(in, 1);
			else map.replace(in, map.get(in)+1);
		}
		
		int cnt = 0;
		
		for (int i = 0; i<N; i++) {
			for (int j = i+1; j<N; j++) {
				int check = 0;
				int tmp = numbers[i]+numbers[j];
				if (tmp == numbers[i]) check++;
				if (tmp == numbers[j]) check++;
				if (map.containsKey(tmp)) {
					if(map.get(tmp) > check) {
						cnt += map.get(tmp);
						map.remove(tmp);
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
