import java.util.Scanner;

public class BOJ_10809 {
	public static void main(String[] args) {
		// 입력받기
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		// 알파벳 갯수만큼 배열만들기(z-a)
		int asciiA = (int) "a".charAt(0);
		int asciiZ = (int) "z".charAt(0);
		
		//출력배열 만들고 -1로 초기화
		int[] places = new int[asciiZ-asciiA+1];
		for (int i=0; i<places.length; i++) {
			places[i] = -1;
		}
		
		// charAt으로 아스키코드 (n-a)
		for (int i=0; i<s.length(); i++) {
			int x = (int) s.charAt(i)-97;

			if (places[x]==-1) {
				places[x] = i;
			}
		}
		
		// 출력
		for (int i=0; i<places.length; i++) {
			System.out.print(places[i]+" ");
			}
			
		}
	}

