import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int repeat = N;
        int answer = 0;
        for (int i = 0; i<repeat; i++){
            int devider = (int)Math.pow(2.0,N-1);
            if (r / devider == 1) answer += devider*devider*2;
            if (c / devider == 1) answer += devider*devider;
            r = r % devider;
            c = c % devider;
            N -= 1;
        }
        System.out.println(answer);
	}
}
