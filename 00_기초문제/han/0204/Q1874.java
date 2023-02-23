import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
	public static void main(String[] args) throws IOException{
        // 기본 IO설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // 입력받고 스택 생성
		int test_case = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

        // 입력에 따라 다음을 실행
        // cnt : 스택에 아직 안넣은 정수의 최소값 - 1
        // input : 입력
		int cnt = 0;
        for (int i = 0; i<test_case; i++){
            int input = Integer.parseInt(br.readLine());
            // 만약 cnt > input인데도 input이 스택의 맨 위에 있지 않다면 수열 생성 불가
            // 만약 cnt > input이고 input이 스택의 맨 위에 있으면 수열 생성 가능
            if (cnt > input && stack.peek() != input) {
                System.out.println("NO"); return;
            }
            
            // 만약 cnt <= input 이라면 아직 스택에 정수를 사용하지 않았단 뜻이므로
            // 스택에 그 수가 들어갈 만큼 push 한 뒤 수를 pop
            else if (cnt <= input) {
                while (cnt != input) {
                    stack.push(++cnt);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }

            // 나머지 경우 : cnt > input이고 input이 스택의 맨 위에 있는 경우
            // 스택에서 input을 뽑아냄
            else{
                stack.pop();
                sb.append("-").append("\n");
            }
        }
		System.out.println(sb);
	}
}
