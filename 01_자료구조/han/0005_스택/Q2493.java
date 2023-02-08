import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
	public static void main(String[] args) throws IOException{
        // 기본 IO설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // 입력받고 스택 생성
		int test_case = Integer.parseInt(br.readLine());
		Stack<set> stack = new Stack<>();
        
        // 일단 base로 21억을 밑에 깔음
        stack.push(new set(Integer.MAX_VALUE, 0));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int cnt = 1;
        
        // (새로 들어오는 수)와 (스택에서 제일 위에 있는 수)를 비교해서
        // (스택에서 제일 위에 있는 수)가 (새로 들어오는 수) 보다 작다면 계속 뽑아서 버림
        // 반복해서 (스택에서 제일 위에 있는 수) 가 (새로 들어오는 수) 보다 크도록 함
        // 그 때의 (스택에서 제일 위에 있는 수) == (찾는 정답) 
        for (int i = 0; i<test_case; i++){
            int N = Integer.parseInt(st.nextToken());
            if (stack.peek().key > N) {
                sb.append(stack.peek().value).append(" ");
                stack.push(new set(N, cnt++));
            }
            else {
                while (stack.peek().key < N) {
                    stack.pop();
                }
                sb.append(stack.peek().value).append(" ");
                stack.push(new set(N, cnt++));
            }
        }
		System.out.println(sb);
	}
}
// 두 개의 int를 인자로 받는 class
class set {
    public int key;
    public int value;
    public set(int key, int value){
        this.key = key;
        this.value = value;
    }
}

