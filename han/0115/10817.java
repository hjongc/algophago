import java.io.*;
import java.util.StringTokenizer;
class q10817 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a >= b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        if (b >= c) {
            int tmp = c;
            c = b;
            b = tmp;
        }
        if (a >= b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        System.out.println(b);
    }
}
