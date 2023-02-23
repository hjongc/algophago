import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int test_case = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<test_case; i++) {
			char[] input = br.readLine().toCharArray();
			int check = 0;
			int answer = 0;
			for (int j = 0; j<input.length; j++) {
				if (((int)input[j]-'0') != check) {
					check = Math.abs(1-check);
					answer++;
				}
			}
			sb.append("#").append(i+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
