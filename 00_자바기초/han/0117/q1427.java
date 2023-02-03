import java.io.*;
import java.util.Arrays;

public class q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String inputString = br.readLine();
        int[] digit = new int[inputString.length()];
        for (int i = 0; i<inputString.length(); i++){
            digit[i] = inputString.charAt(i)-'0';
        }
        Arrays.sort(digit);
        for (int i = digit.length-1; i>=0; i--){
            sb.append(digit[i]);
        }
        System.out.println(sb);

        
    }
}
