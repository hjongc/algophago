import java.util.Scanner;

public class BOJ_17478 {
	
	public static String s1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	public static String s2 = "\"재귀함수가 뭔가요?\"";
	public static String s3_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	public static String s3_2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	public static String s3_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";		
	public static String s4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	public static String s5 = "라고 답변하였지.";
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String tab = "";
		
		System.out.println(s1);
		whatIsRecursion(n, tab);
	}
	
	public static void whatIsRecursion(int n, String tab) {
		if (n==0) {
			System.out.println(tab+s2);
			System.out.println(tab+s4);
			System.out.println(tab+s5);
			return;
		}
		System.out.println(tab+s2);
		System.out.println(tab+s3_1);
		System.out.println(tab+s3_2);
		System.out.println(tab+s3_3);
		
		whatIsRecursion(n-1, tab+"____");
		System.out.println(tab+s5);
	}
}

//어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.

//"재귀함수가 뭔가요?"
//"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."

//____"재귀함수가 뭔가요?"
//____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
//____라고 답변하였지.

//라고 답변하였지.

