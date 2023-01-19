import java.io.*;

public class q1157 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
        int[] count = new int[26];
        int maximum = 0;
        int index = 0;
        boolean valid = true;
        for (int i = 0; i<input.length(); i++) {
            if (input.charAt(i) >= 'a') count[input.charAt(i)-'a']++;
            else count[input.charAt(i)-'A']++;
        }
        for (int j = 0; j<26; j++){
            if (count[j] > maximum){
                maximum = count[j];
                index = j;
                valid = true;
            }
            else if (count[j] == maximum) valid = false;
            else continue;
        }
        if (valid) System.out.println((char)(index+'A'));
        else System.out.println("?");
    }
}
