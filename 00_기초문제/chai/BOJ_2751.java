import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] nums = new boolean[2000000+1];
		int n = Integer.parseInt(br.readLine());
	
		for (int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine())+1000000;
			nums[x] = true;
		}
		
		
		for (int i=0; i<nums.length; i++) {
			if(nums[i]) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
	}
	
}
