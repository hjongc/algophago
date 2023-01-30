import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[10];
		
		while (n>0) {
			nums[n%10]++;
			n/=10;
		}
		
		for (int i=9; i>=0; i--) {
			if (nums[i] > 0) {
				for (int j=0; j<nums[i]; j++) {
					sb.append(i);
				}
			}
		}
		System.out.println(sb);
		
	}
}
