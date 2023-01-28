import java.io.*;
class q10039 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_score = 0;
        for (int i = 0; i<5; i++){
            int score = Integer.parseInt(br.readLine());
            if (score < 40) total_score += 40;
            else total_score += score;
        }
        System.out.println(total_score/5);
    }
}
