import java.io.*;
import java.util.StringTokenizer;
public class q1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int jump = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        int index = 0;
        int cnt = 1;
        int print = 0;
        boolean check[] = new boolean[size];
        sb.append("<");
        while(print != size){
            if (check[index]) {
                if (index==size-1) {index = 0; continue;}
                else {index++; continue;}
            }
            else{
                if (cnt==jump) {
                    print++;
                    cnt = 1;
                    check[index] = true;
                    sb.append(index+1).append(", ");
                    if (index==size-1) {index = 0; continue;}
                    else {index++; continue;}
                }
                else {
                    cnt++; 
                    if (index==size-1) {index = 0; continue;}
                    else {index++; continue;}
                }
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}
