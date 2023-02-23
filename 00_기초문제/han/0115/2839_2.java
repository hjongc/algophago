import java.io.*;
class q2839_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (a%5==0) System.out.println(a/5);
        else if (a>2&&(a-3)%5==0) System.out.println((a-3)/5+1);
        else if (a>5&&(a-6)%5==0) System.out.println((a-6)/5+2);
        else if (a>8&&(a-9)%5==0) System.out.println((a-9)/5+3);
        else if (a>11&&(a-12)%5==0) System.out.println((a-12)/5+4);
        else System.out.println("-1");
    }
}
