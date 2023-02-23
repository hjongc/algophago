import java.util.Scanner;

public class BOJ_4344 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for (int i=0; i<C; i++) {
			int N = sc.nextInt();
			
			//점수배열 만들면서 평균구하기
	
			int[] scores = new int[N];
			double sum = 0;
			for (int j=0; j<N; j++) {
				scores[j] = sc.nextInt();
				sum += scores[j];
			}
			double avg = sum / N;
		
			//평균넘는 인원수 구하기
			double cnt = 0;
			for (int j=0; j<N; j++) {
				if (scores[j] > avg) {
					cnt += 1;
				}
			}
			//비율구하기
			System.out.printf("%.3f%%\n",(cnt/N)*100);
		}
		sc.close();
	}

}
