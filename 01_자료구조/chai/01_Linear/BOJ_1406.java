import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int m = Integer.parseInt(br.readLine());
		
		Stack<Character> stackL = new Stack<>();
		Stack<Character> stackR = new Stack<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			stackL.push(s.charAt(i));
		}
		
		
		
		for(int i = 0; i < m; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
            
			if (c == 'L') {
				if(stackL.size() != 0) {
					stackR.push(stackL.pop());
				}
			}
			
			else if (c == 'D') {
				if(stackR.size() != 0) {
					stackL.push(stackR.pop());
				}
			}
			else if (c == 'B') {
				if(stackL.size() != 0) {
					stackL.pop();
				}
			}
			else if ((c == 'P')) {
				char t = command.charAt(2);
				stackL.push(t);
			}
//			
		}
		
		
		// 출력을 위해 왼쪽 스택에 있던 원소들을 오른쪽 스택에 옮김 
		while(stackL.size() != 0) {
			stackR.push(stackL.pop()); 
		}
			
		// 오른쪽에 담아뒀던 원소 출력 
		while(stackR.size() != 0) {
			bw.write(stackR.pop()); 
		}
		
		bw.flush();
		bw.close();
	}

}
