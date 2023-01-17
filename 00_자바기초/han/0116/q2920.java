import java.io.*;
import java.util.StringTokenizer;
public class q2920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int [8];
        boolean ascending = true;
        boolean descending = true;
        for (int i = 0; i<8; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<7; i++){
            if (input[i] < input[i+1]) descending = false;
            else ascending = false;
        }
        if (ascending == true) System.out.println("ascending");
        else if (descending == true) System.out.println("descending");
        else System.out.println("mixed");
    }
}
