import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		// 재귀 출발~
		Find(K, 1, 3);
		
		// 결과 출력
		System.out.printf("%.0f\n",Math.pow(2, K)-1);
		System.out.println(sb);
	}
	
	public static void Find(int k, int start, int end) {
		// base idea
		// start -> end로 K개 옮기기 는
		// 1. start -> middle 로 k-1개 옮기고
		// 2. start -> end로 원판 한개(k번째) 놓고
		// 3. middle -> end로 k-1개 옮기기
		// 이 떄 start middle end는
		// 원판이 놓여질 장대 번호를 의미함
		int middle = 0;
		if (start == 1) {
			if (end == 2) middle = 3;
			else if (end == 3) middle = 2;
		} else if (start == 2) {
			if (end == 1) middle = 3;
			else if (end == 3) middle = 1;
		} else {
			if (end == 1) middle = 2;
			else if (end == 2) middle = 1;
		}
		
		// 기본값
		if (k == 1) sb.append(start).append(" ").append(end).append("\n");
		
		// 반복
		else {
			Find(k-1, start, middle);
			sb.append(start).append(" ").append(end).append("\n");
			Find(k-1, middle, end);
		}
	}
}
