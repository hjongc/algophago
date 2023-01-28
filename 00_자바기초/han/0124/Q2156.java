import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] wine = new int[number+1];
		for (int i = 0; i<number; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
        if (number == 1) {System.out.println(wine[0]); return;}
		int[] one = new int[number+1];
		int[] two = new int[number+1];
		int[] three = new int[number+1];
		
		one[1] = wine[0];
		two[1] = wine[0];
		one[2] = wine[0] + wine[1];
		
		for (int i = 1; i<=number; i++) {
			if (i>=3) one[i] = Math.max(Math.max(one[i-3], two[i-3]),three[i-3])+wine[i-1]+wine[i-2];
			if (i>=2) two[i] = Math.max(Math.max(one[i-2], two[i-2]),three[i-2])+wine[i-1];
			three[i] = Math.max(Math.max(one[i-1], two[i-1]),three[i-1]);
		}
		System.out.println(Math.max(Math.max(one[number], two[number]),three[number]));
		
	}
}
