import java.util.Scanner;

public class BOJ_8958 {	
	public static void main(String[] args) {
		//readline
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		for (int i=0; i<n;i++) {
			String s = sc.next();
			int cnt = 0; //�������� ����
			int sum = 0; //���� ���� 
			
			for (int j=0; j<s.length(); j++) {
				// O�� �´� �� Ȯ��
				// ������������ Ȯ��
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
