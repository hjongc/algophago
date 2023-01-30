import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[100000];
		int n = Integer.parseInt(br.readLine());
	
		for (int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			nums[x]++;
		}
		
		
		for (int i=0; i<nums.length; i++) {
			if(nums[i]>0) {
                for(int j=0; j<nums[i]; j++){
                    sb.append(i).append("\n");
                }
			}
		}
		System.out.println(sb);
	}
	
}