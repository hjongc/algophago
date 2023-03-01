package day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_2293_세수의합 {
	public static List<Integer> two;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 두 개씩 더한 배열을 만든다. => two
		// 이중for문으로 arr[i]-arr[j] = two[k]인 것을 찾는다.
		// 이때 이분탐색을 이용한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 배열을 입력받는다. 
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 배열을 정렬한다. 
		Arrays.sort(arr);
		
		// 두 개씩 더한 리스트를 만든다.
		two = new ArrayList<>();
		for (int i=0; i<N; i++) {
			for (int j=i; j<N; j++) {
				two.add(arr[i]+arr[j]);
			}
		}
		Collections.sort(two);
		
		// 이중for문으로 arr[i]-arr[j]를 계산하고 그 값이 two에 있는 지 확인한다.
		for (int i=N-1; i>0; i--) { // 가장 큰 수부터 1번인덱스까지 
			for (int j=0; j<i; j++) { // 0번 인덱스부터 i-1번까지 
				int tmp = binary_search(0, two.size()-1, arr[i]-arr[j]);
				if (tmp != -1) {
					System.out.println(tmp+arr[j]);
					return;
				}
			}
		}
		
	}
	public static int binary_search(int range_start, int range_end, int val) {
		int lower = range_start;
		int upper = range_end;
		int mid;
		
		while (lower <= upper) {
			mid = (lower+upper+1)/2;
			if (two.get(mid) == val) return two.get(mid);
			else if (two.get(mid) < val) lower = mid+1;
			else upper = mid-1;
		}
		
		return -1;
	}
}
