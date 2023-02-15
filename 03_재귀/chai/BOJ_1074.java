import java.util.Scanner;

public class BOJ_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int r = sc.nextInt(); // 행 
		int c = sc.nextInt(); // 열 
		
		
		System.out.println(z(N, r, c));
	}
	
	public static int z(int N, int r, int c) {
		if (N==0) return 0;
		
		int side = (int) Math.pow(2, N); // 한 변의 길이 
		int half = side/2; // 한 변의 절반 
		int powHalf = half * half;
		
		// 좌상단 사각형 1
		if (r<half && c<half) return z(N-1, r, c);
		
		// 우상단 사각형 2
		else if (r<half && c>=half) return  powHalf + z(N-1, r, c-half);
		
		// 좌하단 사각형 3
		else if (r>=half && c<half) return 2*powHalf + z(N-1, r-half, c);
		
		// 우하단 사각형 4 
		else return 3*powHalf + z(N-1, r-half, c-half);
	}
}	
