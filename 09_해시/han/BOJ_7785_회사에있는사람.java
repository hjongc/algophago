package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7785_회사에있는사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String status = st.nextToken();
			
			if (status.equals("enter")) {
				map.put(name, 0);
			} else {
				map.remove(name);
			}
		}
		StringBuffer sb = new StringBuffer();
		List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s2, s1) -> s1.compareTo(s2));
        for (String key : keyList) {
        	sb.append(key+"\n");
        }
        System.out.println(sb);
	}
}
