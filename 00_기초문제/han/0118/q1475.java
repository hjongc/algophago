import java.io.*;
public class q1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int[] count = new int[10];
		for (int i = 0; i<cArr.length; i++) count[cArr[i]-'0']++;
		count[6] += count[9];
		count[6] = count[6]%2+count[6]/2;
		int answer = 0;
		for (int i = 0; i<9; i++) {
			if (count[i] > answer) answer = count[i];
		}
		System.out.println(answer);
	}
}
