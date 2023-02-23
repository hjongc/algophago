import java.util.Scanner;

public class BOJ_1924 {
	public static void main(String[] args) {
		// Day of Year 구한다음에 %연산으로 요일 구하기
		
		// 입력
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // month
		int y = sc.nextInt(); // day of month
		sc.close();
		// 일수 정보가 들어있는 배열
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// 7월이면 6월까지 일수 + y
		int daysum = 0; 
		for (int i=1; i<x; i++) {
			daysum += days[i];
		}
		daysum += y; // day of year
				
		//요일 구하기
		int week = daysum%7;
		
		if (week==0) System.out.println("SUN");
		else if (week==1) System.out.println("MON");
		else if (week==2) System.out.println("TUE");
		else if (week==3) System.out.println("WED");
		else if (week==4) System.out.println("THU");
		else if (week==5) System.out.println("FRI");
		else if (week==6) System.out.println("SAT");
	}
}
