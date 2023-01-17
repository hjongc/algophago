import java.io.*;
import java.util.StringTokenizer;
class q1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double result = 0.0;
        double max = 0.0;
        for (int i = 0; i<N; i++){
            double score = (double)Integer.parseInt(st.nextToken());
            if (score >= max) max = score;
            result += score;
    }
        System.out.println(result / N * 100 / max);
    }
}
