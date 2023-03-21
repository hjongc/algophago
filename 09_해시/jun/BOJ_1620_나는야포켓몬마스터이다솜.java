package day0321;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N개 줄에 포켓몬 + M개 줄에 문제
		String[] in = sc.nextLine().split(" ");
		int N  = Integer.parseInt(in[0]);
		int M  = Integer.parseInt(in[1]);
		
		// 숫자 - 포켓몬
		String[] arr = new String[N + 1];
		// 포켓몬 - 숫자
		HashMap<String, Integer> hm = new HashMap<>();
		
		// N개 줄에 포켓몬 
		for(int i = 1; i <= N; i++) {
			// 이름 - 숫자
			String str = sc.nextLine();
			hm.put(str, i);
			// 숫자 - 이름
			arr[i] = str;
		}
		
		// M개 줄에 맞춰야하는 문제가 들어와야
		// 알파벳 -> 포켓몬 번호
		// 숫자 -> 포켓몬 번호에 해당하는 문자
		for(int i = 0; i < M; i++) {
			
			// 입력값
			String str = sc.nextLine();
			// 이름으로 숫자 출력
			if(hm.containsKey(str)) {
				System.out.println(hm.get(str));
			
			// 숫자로 이름 출력
			} else {
				System.out.println(arr[Integer.parseInt(str)]);
			}
		}
		
	}
}