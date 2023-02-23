import java.io.*;
class q11721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        sb.append(br.readLine());
        for (int i = 0; i+10<=sb.length(); i+=10){
            System.out.println(sb.substring(10*(i/10), 10*(i/10)+10));
        }
        System.out.println(sb.substring((sb.length())/10*10,sb.length()));
    }
}
