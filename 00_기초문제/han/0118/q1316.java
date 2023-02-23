import java.io.*;
public class q1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i<test_case; i++) {
			String input = br.readLine();
			boolean[] alphabets = new boolean[26];
			int lastChar = -1;
			for (int j = 0; j<input.length(); j++) {
				int in = input.charAt(j) - 'a';
				if (in == lastChar) continue;
				else if (alphabets[in]) {cnt--; break;}
				else {lastChar = in;alphabets[in]=true;}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
