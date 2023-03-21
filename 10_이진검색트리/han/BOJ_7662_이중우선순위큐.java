package han;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<testCase; tc++) {
			PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> {
				if ((long) o2 - (long) o1 >= 0)
					return 1;
				else
					return -1;
			});
			
			PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> {
				if ((long) o1 - (long) o2 >= 0)
					return 1;
				else
					return -1;
			});
			
			HashMap<Integer, Integer> count = new HashMap<>();
			
			int k = Integer.parseInt(br.readLine());
			
			for (int i = 0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				if (st.nextToken().charAt(0) == 'I') {
					int in = Integer.parseInt(st.nextToken());
					max.offer(in);
					min.offer(in);
					if (count.containsKey(in)) {
						count.replace(in, count.get(in)+1);
					} else {
						count.put(in, 1);
					}
				} else {
					int in = Integer.parseInt(st.nextToken());
					boolean flag = false;
					int tmp = 0;
					if (in == 1) {
						if (!max.isEmpty()) {
							tmp = max.poll(); 
							if (count.get(tmp) > 0) flag=true; 
							else {
								while (!max.isEmpty()) {
									tmp = max.poll();
									if (count.get(tmp) > 0) {
										flag = true;
										break;
									}
								}
							}
						}
						if (flag) count.replace(tmp, count.get(tmp)-1);
					} else {
						if (!min.isEmpty()) {
							tmp = min.poll(); 
							if (count.get(tmp) > 0) flag=true; 
							else {
								while (!min.isEmpty()) {
									tmp = min.poll();
									if (count.get(tmp) > 0) {
										flag = true;
										break;
									}
								}
							}
						}
						if (flag) count.replace(tmp, count.get(tmp)-1);
					}
				}
			}
			int maxV = Integer.MIN_VALUE;
			int minV = Integer.MAX_VALUE;
			
			while(!max.isEmpty()) {
				int tmp = max.poll();
				if (count.get(tmp) > 0) {
					maxV = tmp;
					break;
				}
			}
			while(!min.isEmpty()) {
				int tmp = min.poll();
				if (count.get(tmp) > 0) {
					minV = tmp;
					break;
				}
			}
			
			if (maxV == Integer.MIN_VALUE && minV == Integer.MAX_VALUE)
				sb.append("EMPTY\n");
			else {
				sb.append(maxV).append(" ").append(minV).append("\n");
			}
		}
		System.out.print(sb);
	}
}
