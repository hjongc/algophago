package baek;
import java.util.Arrays;
public class q4673 {
	public static void main(String[] args) {
		int[] number = new int[10000];
		Arrays.fill(number, 0);
		for (int i = 1; i<10000; i++) {
			int sum = 0;
			int num = i;
			while(num > 0) {
				sum += num%10;
				num/=10;
			}
			if ((sum+i)<10000) number[(sum+i)]=1;
		}
		for (int j = 1; j<10000; j++) {
			if (number[j] != 1) System.out.println(j);
		}
	}
}
