import java.io.*;
import java.util.StringTokenizer;
public class q2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int i = 0; i<test_case; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			String input = st.nextToken();
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j<input.length(); j++){
				for (int k = 0; k<repeat; k++) sb.append(input.charAt(j));
			}
			System.out.println(sb);
		}
	}
}
