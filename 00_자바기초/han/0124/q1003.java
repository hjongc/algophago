import java.io.*;
public class q1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[41];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i<=40; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		for (int i = 0; i<N; i++){
			int k = Integer.parseInt(br.readLine());
			if (k == 0) System.out.println("1 0");
			else System.out.printf("%d %d\n", a[k-1], a[k]);
		}
	}
}
