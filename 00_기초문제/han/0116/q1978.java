import java.io.*;
import java.util.StringTokenizer;
public class q1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = 0;
		for (int i = 0; i<N; i++) {
			int numbers = Integer.parseInt(st.nextToken());
			if (isPrime(numbers) == true) answer++;
		}
		System.out.println(answer);
	}
	public static boolean isPrime(int n) {
		if (n<2) return false;
		for (int i = 2; i<n; i++) {
			if (n%i == 0) return false;
		}
		return true;
	}
}
