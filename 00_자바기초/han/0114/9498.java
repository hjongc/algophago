import java.io.*;
class q9498 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (90<= n) bw.write("A");
        else if (80<= n) bw.write("B");
        else if (70<= n) bw.write("C");
        else if (60<= n) bw.write("D");
        else bw.write("F");
        bw.flush();
    }
}
