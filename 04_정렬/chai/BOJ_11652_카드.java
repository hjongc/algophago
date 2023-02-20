import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_11652_카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// hashmap을 사용하여 숫자 카드 갯수를 센다.
		// key는 long으로 한다.
		// 나중에 value값이 가장 높은 키값을 찾는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		String maxKey = "";
		int cntMax = 0;
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			
			// 이미 맵에 있는 값이면?
			// value++;
			if (map.containsKey(s)) {
				int cValue = map.get(s);
				map.put(s, ++cValue);
			}
		
			// 맵에 없는 값이면
			// 새롭게 추가하고 value = 1;
			
			if (!map.containsKey(s)) map.put(s, 1);
			
			// 현재 valueMax와 카운트가 같아진다면
			// key 대소비교를 한다.
			if (map.get(s) == cntMax) {
				if (Long.parseLong(s) < Long.parseLong(maxKey)) maxKey = s;
			}
			
			// s가 최대 value이면 업데이트 해주기 
			if (map.get(s) > cntMax) {
				cntMax = map.get(s);
				maxKey = s;
			}
			
			
		}
		System.out.println(Long.parseLong(maxKey));
	}
}
