import java.io.*;
public class q2442 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
		for (int i = 0; i<n; i++){
            for (int j = 0; j<n-i-1; j++){
                bw.write(" ");
            }
            for (int k = 0; k<=i*2; k++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
	}
}
