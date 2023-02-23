import java.io.*;
class q2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n ; i++){
            for (int j = n-1; j >= i ; j--){
                bw.append(" ");
            }
            for (int k = 1; k <= i; k++){
                bw.append("*");
            }
            bw.append("\n");
            bw.flush();
        }
    }
}
