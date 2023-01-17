import java.io.*;
public class q1993 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        int remain = 0;
		for (int i=1;;i++){
            cnt+=i;
            if (cnt>=N) {
                remain = cnt-N; 
                cnt = i;
                break;
            }  
        }
        int b = 1;
        
        if (cnt%2 == 0) {
            for (int j = 0; j<remain; j++){
                cnt--;
                b++;
            }
            sb.append(cnt).append("/").append(b);
        }
        else {
            for (int j = 0; j<remain; j++){
                cnt--;
                b++;
            }
            sb.append(b).append("/").append(cnt);
        }
        System.out.println(sb);
	}
}
