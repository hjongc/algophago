import java.io.*;
public class q1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[1000001];
		a[1] = 0;
		a[2] = 1;
		a[3] = 1;
		for (int i = 2; i<=999999; i++) {
			if (a[i+1] > a[i] || a[i+1] == 0) a[i+1] = a[i]+1;
			if (2*i<=1000000 && ((a[2*i] > a[i]) || a[i*2]  == 0)) a[2*i] = a[i]+1;
			if (3*i<=1000000 && ((a[3*i] > a[i]) || a[i*3]  == 0)) a[3*i] = a[i]+1;
		}
		System.out.println(a[N]);
	}
}
