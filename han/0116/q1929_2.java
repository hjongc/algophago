import java.io.*;
import java.util.StringTokenizer;
public class q1929_2 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
		for (int i = N; i<=M; i++) {
			if (isPrime(i)) sb.append(i).append("\n");
		}
        sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	public static boolean isPrime(int n) {
		if (n<2) return false;
		for (int i = 2; i<=Math.sqrt(n); i++) {
			if (n%i == 0) return false;
		}
		return true;
	}
}
