import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        Stack<Character> preStack = new Stack<>();
        Stack<Character> nxtStack = new Stack<>();

        char[] str = br.readLine().toCharArray();
		int test_case = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<str.length; i++){
            preStack.push(str[i]);
        }

        for(int i = 0; i<test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken(); 

            if (command.equals("L")) {
                if (preStack.isEmpty()) continue;
                nxtStack.push(preStack.pop());
            } else if (command.equals("D")) {
                if (nxtStack.isEmpty()) continue;
                preStack.push(nxtStack.pop());
            } else if (command.equals("B")) {
                if (preStack.isEmpty()) continue;
                preStack.pop();
            } else {
                char newChar = st.nextToken().charAt(0);
                preStack.push(newChar);
            }
        }
        while(!preStack.isEmpty()){
            nxtStack.push(preStack.pop());
        }
        while(!nxtStack.isEmpty()){
            sb.append(nxtStack.pop());
        }
        System.out.println(sb);
    }
}

//성공