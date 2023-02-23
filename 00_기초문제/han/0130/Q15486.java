import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15486 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] max = new int[N+2];
		for (int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int date = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			if(date + i <= N+1) {
				max[date+i] = Math.max(max[date+i], money+max[i]);
			}
			max[i+1] = Math.max(max[i],max[i+1]); 
		}
		
		System.out.println(max[N+1]);
		
	}
}
