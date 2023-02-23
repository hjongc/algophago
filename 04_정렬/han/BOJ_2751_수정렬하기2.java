import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] Arr = new int[N];
		
		for (int i = 0; i<N; i++) {
			Arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(Arr, 0, N-1);
		
		for (int element : Arr) {
			bw.write(element+"\n");
		}
		bw.flush();
	}
	
	public static void mergeSort(int[] Arr, int start, int end) {
		if (start == end) return;
		else {
			int middle = (start+end)/2;
			mergeSort(Arr, start, middle);
			mergeSort(Arr, middle+1, end);
			merge(Arr, start, middle, end);
		}
	}
	public static void merge(int[] Arr, int start, int middle, int end) {
		int left = start;
		int right = middle+1;
		int[] sortedArr = new int[end-start+1];
		int cnt = 0;
		
		while(left <= middle && right <= end) {
			if (Arr[left] <= Arr[right]) {
				sortedArr[cnt++] = Arr[left++];
			} else {
				sortedArr[cnt++] = Arr[right++];
			}
		}
		if (left > middle) {
			while(right <= end) {
				sortedArr[cnt++] = Arr[right++];
			}
		} else {
			while(left <= middle) {
				sortedArr[cnt++] = Arr[left++];
			}
		}
		for(int i = 0; i<sortedArr.length; i++) {
			Arr[start++] = sortedArr[i];
		}
		
	}
}
