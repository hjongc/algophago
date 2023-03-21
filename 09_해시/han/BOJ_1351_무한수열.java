package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BOJ_1351_무한수열 {
	public static long P;
	public static long Q;
	public static Map<Long, Long> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		map = new HashMap<>();
		
		System.out.println(calculate(N));
	}
	
	public static long calculate(long input) {
		if (input == 0) return 1;
		long devideP = input/P;
		long devideQ = input/Q;
		long valueP;
		long valueQ;
		if (map.containsKey(devideP)) {
			valueP = map.get(devideP);
		} else {
			valueP = calculate(devideP);
		}
		if (map.containsKey(devideQ)) {
			valueQ = map.get(devideQ);
		} else {
			valueQ = calculate(devideQ);
		}
		return (valueP + valueQ);
	}
}
