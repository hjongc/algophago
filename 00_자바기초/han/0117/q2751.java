import java.io.*;
import java.util.Arrays;
public class q2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		int[] numbers = new int[test_case];
		for (int i = 0; i<test_case; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);
		for (int i = 0; i<test_case; i++) {
			bw.write(numbers[i]+"\n");
		}
		bw.flush();
	}
}
