import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BOJ_1157 {
	public static void main(String[] args) {
		// hashmap 사용하기
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next().toUpperCase(); //대문자로 만들기
		sc.close();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		
		// 반복문, charAt 이용해서 갯수
		
		for (int i=0; i<s.length(); i++) {
			int tmp;
			Character c =  s.charAt(i);
			if (map.containsKey(c)) { // 이미 key가 있으면
				tmp = map.get(c)+1;
				map.put(c, tmp);
			}
			else {
				map.put(c, 1);
			}
		}
	
		// 최댓값 확인
		char max_char = 0;
		int max = 0;
		int same_cnt=0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			
			if (value > max) {
				max_char = key;
				max = value;
				same_cnt = 1;
			}
			else if (value == max) {
				same_cnt++;
			}
		}
		if (same_cnt>1) {
			System.out.println("?");
			return;
		}
		else {
			System.out.println(max_char);
		}
		
		
	}
}
