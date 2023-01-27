import java.io.*;
class q2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = findSugar(a);
        if (b<10000) System.out.println(b);
        else System.out.println("-1");
    }
    public static int findSugar(int n){
        if (n%5==0) return n/5;
        else if (n==3&&n<15) return n/3;
        else if (n<5) return 10000;
        else return findSugar(n-3)+1;
    }
}
