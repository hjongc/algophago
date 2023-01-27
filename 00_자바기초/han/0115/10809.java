import java.io.*;
import java.util.Arrays;
class q10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabets = new int[26];
        StringBuffer sb = new StringBuffer();
        Arrays.fill(alphabets, -1);
        for (int i = 0; i < word.length(); i++){
            int a = word.charAt(i)-'a';
            if (alphabets[a] == -1) alphabets[a] = i;
            else continue;
        }
        for (int j:alphabets) sb.append(j).append(" ");
        System.out.println(sb);
    }
}
