package b7662;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int K = sc.nextInt();
			
			TreeMap<Integer, Integer> Q = new TreeMap<>();
			for(int k=1; k<=K; k++) {
				String exec = sc.next();
				int value = sc.nextInt();
				
				if(exec.equals("D") && Q.size() == 0) continue;
				
				if(exec.equals("D") && value == -1) {
					if(Q.get(Q.firstKey()) > 1) Q.put(Q.firstKey(), Q.get(Q.firstKey())-1);
					else Q.remove(Q.firstKey());
				}
				
				if(exec.equals("D") && value == 1) {
					if(Q.get(Q.lastKey()) > 1) Q.put(Q.lastKey(), Q.get(Q.lastKey())-1);
					else Q.remove(Q.lastKey());
				}
				
				int input = Q.get(value) == null ? 1 : Q.get(value)+1;
				if(exec.equals("I")) Q.put(value, input);
				
			}
			if(Q.size() == 0) System.out.println("EMPTY");
			else System.out.println(Q.lastKey()+" "+Q.firstKey());
		}
	}
}
