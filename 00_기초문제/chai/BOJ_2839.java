
import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		sc.close();
		
		// while 반복문 안에
		// 5로 나누어지는지 먼저 확인하고
		// 만약 나눠지지 않는다면 -3하고
		// 다시 5로 나누어지는지 확인하기
		int cnt = 0; // 봉지 수
		while (weight>0) {
			if (weight%5==0) {
				cnt += (weight/5);
				break;
			}
			else {
				weight -= 3;
				cnt += 1;
			}
		}
		
		if (weight < 0) System.out.println(-1);
		else System.out.println(cnt);
		
		}

}
