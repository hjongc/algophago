import java.io.*;
public class q9012 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            String input = br.readLine();
            int okay = 0;
            boolean valid = true;
            for (int j =0; j<input.length(); j++){
                if (input.charAt(j) == '(') okay++;
                else okay--;
                if (okay < 0) valid = false;
            }
            if (valid == true && okay == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
