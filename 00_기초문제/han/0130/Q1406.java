import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		list[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken()) + list[i-1];
		}
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == 1) bw.write(String.valueOf(list[end-1]));
			else bw.write(String.valueOf(list[end-1]-list[start-2]));
			bw.write("\n");
		}
		bw.flush();
	}
}
