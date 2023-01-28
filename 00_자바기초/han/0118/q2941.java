import java.io.*;
public class q2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int answer = input.length;
		for(int i=1; i<input.length; i++) {
			if (input[i] == (char)'-' && (input[i-1] == (char)'c' || input[i-1] == (char)'d')) answer--;
			else if (input[i] == (char)'=') {
				if (input[i-1] == (char)'z' && i>1 && input[i-2] == (char)'d') answer-=2;
				else answer--;
			}
			else if (input[i] == (char)'j' && (input[i-1] == (char)'l' || input[i-1] == (char)'n')) answer--;
		}
		System.out.println(answer);
	}
}
