import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class q11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] lines = new int[n];
		for (int i = 0; i<n; i++) lines[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(lines);
		
		int answer = 0;
		for (int j = 0; j<n; j++) answer+=(lines[j]*(n-j));
		
		System.out.println(answer);
	}
}
