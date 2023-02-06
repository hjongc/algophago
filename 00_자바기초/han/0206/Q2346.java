import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2346 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuffer sb = new StringBuffer();
		
		Deque<set> deque = new ArrayDeque<>();
		
		int cnt = 1;
		
		for (int i = 0; i<size; i++) {
			int input = Integer.parseInt(st.nextToken());
			deque.offer(new set(cnt++,input));
		}
		
		cnt = 1;
		while(!deque.isEmpty()) {
			if (cnt < 0) {
				deque.offerFirst(deque.pollLast());
				cnt++;
			} else if (cnt >1 ) {
				deque.offer(deque.poll());
				cnt--;
			} else {
			set out = deque.poll();
			sb.append(out.order);
			cnt = out.number;
			}
		}
		System.out.println(sb);
		
	}
}
class set {
	public set(int i, int input) {
		this.order = i; 
		this.number = input;
	}
	public int order;
	public int number;
}