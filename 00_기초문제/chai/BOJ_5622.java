import java.util.Scanner;

public class BOJ_5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			int c = (int) s.charAt(i);
			
			if (65<=c && c<68) sum += 3; // ABC는 3초
			else if (c<71) sum += 4;
			else if (c<74) sum += 5;
			else if (c<77) sum += 6;
			else if (c<80) sum += 7;
			else if (c<84) sum += 8;
			else if (c<87) sum += 9;
			else sum += 10;
			
		}
		System.out.println(sum);
	}
}

//2 ABC
//3 DEF
//4 GHI
//5 JKL
//6 MNO
//7 PQRS
//8 TUV
//9 WXYZ