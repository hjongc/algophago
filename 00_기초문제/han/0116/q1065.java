import java.io.*;
public class q1065 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int j = 1; j<=N; j++ ) {
			if (j<=99) answer++;
			else if ((j%10+j/100) == 2*((j%100)/10)) answer++;
			else continue;
		}
		System.out.println(answer);
	}
}

