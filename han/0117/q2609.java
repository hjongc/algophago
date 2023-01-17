package baek0117;
import java.io.*;
import java.util.StringTokenizer;
public class q2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int mini = Math.min(a, b);
		int GD = 1;
		for (int i = 1; i<=mini; i++) {
			if (a%i==0&&b%i==0) GD=i;
		}
		System.out.println(GD);
		System.out.println(a*b/GD);
	}
}
