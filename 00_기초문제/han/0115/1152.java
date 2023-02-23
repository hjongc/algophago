import java.io.*;
class q1152 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int SpaceNumber = 0;
        for (int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ' ' && (line.length() == 1)) {System.out.println('0'); return;}
            else if(line.charAt(i) == ' ' && (i == 0||i==line.length()-1)) continue;
            else if(line.charAt(i) == ' ') SpaceNumber ++;
        }
        System.out.println(SpaceNumber+1);
    }
}
