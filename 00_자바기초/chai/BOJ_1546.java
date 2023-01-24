import java.util.Scanner;

public class BOJ_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		int[] scores = new int[m];
		
		// 점수 배열에 저장 
		// 최댓값 찾기
		double max = 0;
		for (int i=0; i<m; i++) {
			scores[i] = sc.nextInt();
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		// 새로운 점수 구하기
		double newSum = 0;
		for (int i=0; i<m; i++) {
			newSum += scores[i]/max*100;
		}
		// 평균구하기
		System.out.printf("%f", newSum/m);
		sc.close();
	}

}
