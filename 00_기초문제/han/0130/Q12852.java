import java.io.*;
public class Q12852 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		while(N>1) {
			if (N%3 == 0 && a[N/3] == a[N]-1) {bw.write(String.valueOf(N)); bw.append(" "); N/=3;}
			else if (N%2 == 0 && a[N/2] == a[N]-1) {bw.write(String.valueOf(N)); bw.append(" "); N/=2;}
			else {bw.write(String.valueOf(N)); bw.append(" "); N--;}		
		}
		bw.write('1');
		bw.flush();
	}
}
