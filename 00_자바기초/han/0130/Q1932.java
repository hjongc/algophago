import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[][] triangle = new int[size+1][size+1];
		triangle[1][1] = Integer.parseInt(br.readLine());
		for (int i = 2; i<=size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j<=i; j++) {
				triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + Integer.parseInt(st.nextToken());
			}
		}
		int maximum = Integer.MIN_VALUE;
		for (int i = 1; i<=size; i++) {
			if (triangle[size][i] > maximum) maximum = triangle[size][i];
		}
		System.out.println(maximum);
	}
}
