import java.io.*;
import java.util.StringTokenizer;
public class q1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
        for (int i = 0; i < test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            double answer = 1;
            for (int j = N+1; j<= M; j++) answer *= j;
            for (int k = 1; k<=M-N; k++) answer /= k;
            System.out.printf("%.0f\n",answer);
        }
    }
}
