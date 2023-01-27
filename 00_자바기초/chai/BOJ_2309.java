import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		
		// 일단 배열에 넣고 오름차순 정렬 
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		sc.close();
		
		// 난쟁이 두 명씩 고르고 빼기
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (sum-arr[i]-arr[j]==100) {
					for (int k=0; k<arr.length; k++) {
						if (k == i) continue;
						else if (k==j) continue;
						else System.out.println(arr[k]);
						
					}
					return;
				}
			}
		}
		
	}
}
