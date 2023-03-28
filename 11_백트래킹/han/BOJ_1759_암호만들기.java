import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	
	public static StringBuffer sb = new StringBuffer();
	public static char[] alphabets;
	public static boolean[] selected;
	
	public static int L;
	public static int C;
	
	public static int aeiou;
	public static int notaeiou;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabets = br.readLine().replace(" ","").toCharArray();
		Arrays.sort(alphabets);
		selected = new boolean[C];
		
		for (int i = 0; i <= C-L+1; i++) {
			selected[i] = true;
			if (isAeiou(alphabets[i])) aeiou++;
			else notaeiou++;
			password(i, 1);
			selected[i] = false;
			if (isAeiou(alphabets[i])) aeiou--;
			else notaeiou--;
		}
		System.out.println(sb);
	}
	public static void password(int i, int cnt) {
		if (cnt == L && aeiou > 0 && notaeiou > 1) {
			for (int a = 0; a<=i; a++) {
				if (selected[a]) {
					sb.append(alphabets[a]);
				}
			}
			sb.append("\n");
			return;
		} else if (cnt == L) {
			return;
		}
		for (int a = i+1; a <= C - (L-cnt); a++) {
			selected[a] = true;
			if (isAeiou(alphabets[a])) aeiou++;
			else notaeiou++;
			password(a, cnt+1);
			selected[a] = false;
			if (isAeiou(alphabets[a])) aeiou--;
			else notaeiou--;
		}
	}
	public static boolean isAeiou(char alpha) {
		return (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u');
	}

}
