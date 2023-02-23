import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2011 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] ans = new int[input.length+2];
		ans[input.length] = 1;
		if (input[input.length-1] == '0') ans[input.length-1] = 0;
		else {ans[input.length-1] = 1;}
		for(int i = input.length-2; i>=0; i--) {
			if ((int)input[i]-48 == 1) ans[i] = ans[i+1]%1000000 + ans[i+2]%1000000;
			else if ((int)input[i]-48 == 0) ans[i] = 0;
			else if ((int)input[i]-48 == 2 && (int)(input[i+1])-48 <= 6) ans[i] = ans[i+1]%1000000 + ans[i+2]%1000000;
			else ans[i] = ans[i+1]%1000000;
		}
		if (input[0] == '0') System.out.println(0);
		else System.out.println(ans[0]%1000000);
	}
}
