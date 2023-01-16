package baek;
import java.io.*;
public class Q8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<N; i++) {
			String input = br.readLine();
			int add = 0;
			int answer = 0;
			for (int j = 0; j<input.length(); j++) {
				if (input.charAt(j) == 'O') {
					add += 1;
					answer += add;
				}
				else add = 0;
			}
			System.out.println(answer);
		}
	}
}
