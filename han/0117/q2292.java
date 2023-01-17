package baek0117;
import java.io.*;
public class q2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		for (int i = 0;;i++) {
			if(cnt+i*6 >= N) {System.out.println(i+1); break;}
			else cnt+=i*6;
		}
	}
}
