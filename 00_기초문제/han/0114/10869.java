import java.io.*;
import java.util.StringTokenizer;
class q10869 {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(a+b));
        bw.write("\n"+String.valueOf(a-b));
        bw.write("\n"+String.valueOf(a*b));
        bw.write("\n"+String.valueOf(a/b));
        bw.write("\n"+String.valueOf(a%b));
        bw.flush();
    }
}
