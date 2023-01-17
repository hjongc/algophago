import java.io.*;

public class q11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        long[] ans = new long[N+1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i<=N; i++){
            ans[i] = ans[i-1]%10007 + 2*ans[i-2]%10007;
        }
        System.out.println(ans[N]%10007);
    }
}
