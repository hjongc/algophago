import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> dq = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 초기값 데크에 입력 
		for (int i=0; i<n; i++) {
			int[] tmpArr = new int[] {i+1, Integer.parseInt(st.nextToken())};
			dq.addLast(tmpArr); 
		}
		
		// 첫 번째는 무조건 뽑기 
		sb.append(dq.peekFirst()[0]+" ");
		int cmd = dq.pollFirst()[1];
		
		
		while (!dq.isEmpty()) {
			if (cmd > 0) { // 풍선 안의 번호가 양수일 때는 맨 앞을 맨 뒤로 n-1번 
				for (int j=1; j < cmd; j++) {
					dq.addLast(dq.pollFirst());
				}
			}
			else { // 풍선 안의 번호가 음수일 때는 맨 뒤를 맨 앞으로 n번 
				for (int j=0; j < -cmd; j++) {
					dq.addFirst(dq.pollLast());
				}
		}
		cmd = dq.peekFirst()[1];
		sb.append(dq.pollFirst()[0]+" ");
		
		}	
		
		System.out.println(sb);
	}
}
