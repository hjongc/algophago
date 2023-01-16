import java.io.*;
import java.util.StringTokenizer;
class q10430{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf((A+B)%C)+"\n");
        bw.write(String.valueOf(((A%C) + (B%C))%C)+"\n");
        bw.write(String.valueOf((A*B)%C)+"\n");
        bw.write(String.valueOf( ((A%C) * (B%C))%C));
        bw.flush();
    }
}