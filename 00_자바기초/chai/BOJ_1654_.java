import java.util.Scanner;

public class BOJ_1654_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[k];
		int max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) max = arr[i];
		}
	
		
		for (int i = max; i > 0; i--) {
			int cnt = 0;
			for (int j=0; j<k; j++) {
				cnt += arr[j]/i;
			}
			
			if (cnt == n) {
				System.out.println(i);
				return;
			}
		}
	}
}
