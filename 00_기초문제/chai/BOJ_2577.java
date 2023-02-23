import java.util.Scanner;

public class BOJ_2577 {

	public static void main(String[] args) {
		//입력받기
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt(); 
		int c = sc.nextInt();
		sc.close();
		
		//곱하기
		int num = a*b*c;
		
		//while 이용해서 일의자리 뽑기
		//뽑힌 숫자 인덱스로 올리기
		int[] cnts = new int[10];
		
		while (num > 0) {
			cnts[num%10] += 1;
			num /= 10;
		}
		for (int i=0; i<10; i++) {
			System.out.println(cnts[i]);
		}
	}

}
