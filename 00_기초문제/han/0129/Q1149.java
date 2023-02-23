import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] one = new int[N+1];
        int[] two = new int[N+1];
        int[] three = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        one[0] = Integer.parseInt(st.nextToken());
        two[0] = Integer.parseInt(st.nextToken());
        three[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            one[i] = Math.min(two[i-1],three[i-1]) + Integer.parseInt(st2.nextToken());
            two[i] = Math.min(one[i-1],three[i-1]) + Integer.parseInt(st2.nextToken());
            three[i] = Math.min(two[i-1],one[i-1]) + Integer.parseInt(st2.nextToken());
        }
        int minimum = Math.min(Math.min(one[N-1],two[N-1]),three[N-1]);
        System.out.println(minimum);
	}
}
