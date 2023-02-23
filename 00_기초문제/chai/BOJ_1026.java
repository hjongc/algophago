import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1026 {
	public static void main(String[] args) {
		// A, B 모두 정렬
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		
		Arrays.sort(a); // 오름차순
		Arrays.sort(b);
		
		int matmul = 0;
		for (int i = 0; i < n; i++) {
			matmul += a[i] * b[n-1-i];
		}
		System.out.println(matmul);
	}
}
