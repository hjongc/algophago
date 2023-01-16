import java.io.*;
class q11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i<n; i++){
            result += br.read()-48;
        } 
        System.out.println(result);
    }
}
