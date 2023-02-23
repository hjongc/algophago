import java.util.Scanner;

public class BOJ_8958 {	
	public static void main(String[] args) {
		//readline
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		for (int i=0; i<n;i++) {
			String s = sc.next();
			int cnt = 0; //연속정답 변수
			int sum = 0; //점수 변수 
			
			for (int j=0; j<s.length(); j++) {
				// O이 맞는 지 확인
				// 연속정답인지 확인
				if (s.charAt(j) == 'O') {
					cnt++;
					sum += cnt;
				}
				else {
					cnt=0;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
