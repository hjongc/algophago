import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(Repeat(A,B,C));
	}
	
	public static long Repeat(int A, int B, int C) {
		if (B == 0) {
			return 1;
		} else if (B%2 == 0){
			long sqrt = Repeat(A,B/2,C)%C;
			return (sqrt * sqrt)%C;
		} else {
			return (A*Repeat(A,B-1,C)%C);
		}
	}
}
