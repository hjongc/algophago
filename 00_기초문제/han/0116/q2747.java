import java.io.*;

public class q2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        long[] ans = new long[N+1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i<=N; i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        System.out.println(ans[N]);
    }
}
