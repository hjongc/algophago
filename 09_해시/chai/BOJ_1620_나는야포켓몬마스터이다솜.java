package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		
		int num = 0;
		for (int i=0; i<N; i++) {
			String pokemon = br.readLine();
			
			map1.put(pokemon, ++num);
			map2.put(num, pokemon);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			String cmd = br.readLine();
			
			if ('0'<=cmd.charAt(0) && cmd.charAt(0)<='9') {
				sb.append(map2.get(Integer.parseInt(cmd)))
					.append("\n");
			}
			else {
				sb.append(map1.get(cmd))
				.append("\n");
			}
		}
		System.out.println(sb);
	}
}
