import java.util.Scanner;

public class BOJ_10809 {
	public static void main(String[] args) {
		// �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		// ���ĺ� ������ŭ �迭�����(z-a)
		int asciiA = (int) "a".charAt(0);
		int asciiZ = (int) "z".charAt(0);
		
		//��¹迭 ����� -1�� �ʱ�ȭ
		int[] places = new int[asciiZ-asciiA+1];
		for (int i=0; i<places.length; i++) {
			places[i] = -1;
		}
		
		// charAt���� �ƽ�Ű�ڵ� (n-a)
		for (int i=0; i<s.length(); i++) {
			int x = (int) s.charAt(i)-97;

			if (places[x]==-1) {
				places[x] = i;
			}
		}
		
		// ���
		for (int i=0; i<places.length; i++) {
			System.out.print(places[i]+" ");
			}
			
		}
	}

