import java.util.Scanner;

public class BOJ_1924 {
	public static void main(String[] args) {
		// Day of Year ���Ѵ����� %�������� ���� ���ϱ�
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // month
		int y = sc.nextInt(); // day of month
		sc.close();
		// �ϼ� ������ ����ִ� �迭
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// 7���̸� 6������ �ϼ� + y
		int daysum = 0; 
		for (int i=1; i<x; i++) {
			daysum += days[i];
		}
		daysum += y; // day of year
				
		//���� ���ϱ�
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
