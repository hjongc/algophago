import java.io.*;
import java.util.StringTokenizer;
public class q1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int small = Integer.parseInt(st.nextToken());
        if (small == 1) small++;
        int big = Integer.parseInt(st.nextToken());
        for (int i=small; i<=big; i++){
            boolean valid = true;
            for (int j=2; j<=Math.sqrt(big); j++){
                if (i%j == 0 && i!=j) {valid = false; break;}
            }
            if (valid) System.out.println(i);
            else continue;
        }
    }
}
