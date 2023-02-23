import java.io.*;
class q2739 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i<= 9; i++){
            sb.append(n).append(" * ").append(i).append(" = ").append(n*i).append("\n");
        }
        System.out.println(sb);
    }
}
