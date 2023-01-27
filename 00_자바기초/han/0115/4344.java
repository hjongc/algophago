import java.io.*;
import java.util.StringTokenizer;
class q4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int test_case = Integer.parseInt(st.nextToken());
            int[] score = new int[test_case];
            int total = 0;
            for (int j = 0; j<test_case; j++){
                int test_score = Integer.parseInt(st.nextToken());
                score[j] = test_score;
                total += test_score;
            }
            double average = total/ ((double)test_case);
            double pass = 0.0;
            for (int j = 0; j<test_case; j++){
                if (score[j] > average) pass++;
        }
            System.out.println(String.format("%.3f%%",(pass*100/test_case)));
    }
    }
}
