package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int command = Integer.parseInt(st.nextToken());
		
		// pokemonsArr : 인덱스로 포켓몬 찾기
		// pokemonMap : 포켓몬 이름으로 인덱스 찾기
		String[] pokemonsArr = new String[N+1];
		HashMap<String, Integer> pokemonsMap = new HashMap<>();
		
		for (int i = 1; i<=N; i++) {
			String current = br.readLine();
			pokemonsArr[i] = current;
			pokemonsMap.put(current, i);
		}
		
		// 숫자입력 : 배열에서 찾기
		// 문자입력 : 맵에서 찾기
		for (int i = 0; i<command; i++) {
			String current = br.readLine();
			if (current.charAt(0) >= '0' && current.charAt(0) <= '9') {
				sb.append(pokemonsArr[Integer.parseInt(current)]).append("\n");
			} else {
				sb.append(pokemonsMap.get(current)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
