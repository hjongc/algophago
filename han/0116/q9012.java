import java.io.*;
class q9012{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        here : for (int i = 0; i<N; i++){
            String input = br.readLine();
            int okay = 0;
            for (int j =0; j<input.length(); j++){
                if (input.charAt(j) == '(') okay++;
                else okay--;
                if (okay <= 0) {System.out.println("NO"); break here;}
            }
            System.out.println("YES");
        }

    }
}