package day0224;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] meetings = new int[N][2];
		for (int i=0; i<N; i++) {
			meetings[i][0] = sc.nextInt(); // start
			meetings[i][1] = sc.nextInt(); // end
		}
		
		Comparator<int[]> comparator = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
			
		};
		Arrays.sort(meetings, comparator);
		
		int cnt = 0; // 회의갯수 변수
		int end = 0;
		for (int i=0; i<N; i++) {
			if (end <= meetings[i][0]) {
				end = meetings[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}	

