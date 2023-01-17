package baek0117;
import java.io.*;
import java.util.Arrays;
public class q2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[9];
		int sum = 0;
		for(int i = 0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		sum-=100;
		Arrays.sort(height);
		here:for(int i = 0; i<8; i++) {
			for (int j = i+1; j<9; j++) {
				if (height[i]+height[j] == sum) {
					for (int k = 0;k<9;k++) {
						if(k==i||k==j) continue;
						else System.out.println(height[k]);
						}
					break here;
				}
			}
		}
	}
}
