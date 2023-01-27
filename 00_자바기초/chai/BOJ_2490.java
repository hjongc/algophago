import java.util.Scanner;

public class BOJ_2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int i=0; i<3; i++) {
			
			int[] arr = new int[2];
			for (int j=0; j<4; j++) {
				arr[sc.nextInt()]++;
			}
			
			if  (arr[0]==0) {
				System.out.println("E");
			}
			else if (arr[0]==1) {
				System.out.println("A");
			}
			else if  (arr[0]==2) {
				System.out.println("B");
			}
			else if  (arr[0]==3) {
				System.out.println("C");
			}
			else if  (arr[0]==4) {
				System.out.println("D");
			}
			
			
		}
		sc.close();
	}
}

// 0 도 A
// 00 개 B
// 000 걸 C
// 0000 윷 D
