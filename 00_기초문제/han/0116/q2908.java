import java.io.*;
import java.util.StringTokenizer;

public class q2908  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int input1 = Integer.parseInt(st.nextToken());
    int input2 = Integer.parseInt(st.nextToken());
    input1 = input1 +(input1%10)*100 + (input1/100) - (input1/100)*100 -input1%10;
    input2 = input2 +(input2%10)*100 + (input2/100) - (input2/100)*100 -input2%10;
    if (input1>input2) System.out.println(input1);
    else System.out.println(input2);
    }
    
}
