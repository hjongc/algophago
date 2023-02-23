package baek0127;
import java.io.*;
import java.util.StringTokenizer;
public class q11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] count = new int[1001];
		int[] price = new int[1001];
		for (int i = 1; i<1001; i++ ) {
			if (st.hasMoreTokens()) price[i] = Integer.parseInt(st.nextToken());
		}
		count[1] = price[1];
		for (int j = 2; j<N+1; j++) {
			for (int k = 1; k<=j; k++) {
				count[j] = Math.max(count[j], price[k]+count[j-k]);
			}
		}
		System.out.println(count[N]);
		
	}
}
