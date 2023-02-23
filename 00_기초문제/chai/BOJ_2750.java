import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 배열 저장
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 정렬
		Arrays.sort(arr);
		
		//하나씩 출력
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
