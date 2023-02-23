
import java.util.Scanner;

public class BOJ_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int cnt = 0;
		
		int newNum = N;
		while (true) {
			cnt+=1;
			int a = newNum/10; //십의 자리
			int b = newNum%10; //일의 자리
			
			newNum = b*10+(a+b)%10;

			//정지조건
			if(newNum==N) {
				System.out.println(cnt);
				break;
			}
			
			
		}
	}

}
