
public class BOJ_4673 {

	public static void main(String[] args) {
		boolean[] bArr = new boolean[10001];
		
		for (int i=1; i<=10000; i++) {
			int n = d(i);
			
			if (n <10001) {
				bArr[n] = true;
			}
		}
		for (int i=1; i<=10000;i++) {
			if (bArr[i]==false) {
				System.out.println(i);
			}
		}
	}
	
	public static int d(int num) {
		int sum = num;
		
		while (num > 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}

}
