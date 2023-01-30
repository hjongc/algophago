import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		long[] answer = new long[101];
		answer[1] = 1;
		answer[2] = 1;
		answer[3] = 1;
		answer[4] = 2;
		for (int i = 5; i<101; i++) {
			answer[i] = answer[i-1] + answer[i-5];
		}
		for (int i = 0; i<test_case; i++) {
			System.out.println(answer[Integer.parseInt(br.readLine())]);
		}
	}
}
