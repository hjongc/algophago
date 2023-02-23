import java.util.Scanner;

public class BOJ_2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 별 늘어나는 부분 
		
		// 마지막줄 별 갯수
		// 2n-1
		for (int i=0; i<n; i++) {
			// 공백 넣기 
			for (int j=i+1; j<n; j++) {
				System.out.print(" ");
			}
				
			// 별 넣기
			for (int j=0; j<2*i+1; j++) {
				System.out.print("*"); 
			}
			System.out.println();	
		}
		
		// 별 줄어드는 부분 
		for (int i=1; i<n; i++) { // n-1번 반복 
			// 공백 넣기
			for (int j=0; j<i; j++) {
				System.out.print(" ");
			}
			
			// 별 넣기
			
			for (int j=0; j<(n-1-i)*2+1; j++) { 
				System.out.print("*");
			}
			System.out.println();
			
		
		}
		sc.close();
	}
}

// 5
// n      공백     별
// 1        4       1
// 2        3       3
// 3        2       5
// 4        1       7
// 5        0       9
// 1        1       7  (n-1-i)*2+1
// 2        2       5
// 3        3       3
// 4        4       1