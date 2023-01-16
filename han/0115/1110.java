import java.io.*;
class q1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int N_check = N;
        while (true){
            result++;
            N = (N/10+N%10)%10+N%10*10;
            if (N_check == N) break;
        }
        System.out.println(result);
    }
}
