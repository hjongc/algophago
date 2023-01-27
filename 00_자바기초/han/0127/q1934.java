package baek0127;
import java.io.*;
import java.util.StringTokenizer;
public class q1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int k = 0; k<test_case; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int mini = Math.min(a, b);
			int GD = 1;
			for (int i = 1; i<=mini; i++) {
				if (a%i==0&&b%i==0) GD=i;
			}
			System.out.println(a*b/GD);
		}
	}
	
}
