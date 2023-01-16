import java.io.*;
class q2742 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = n; i>0; i--){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
