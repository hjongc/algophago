import java.io.*;
import java.util.Stack;
public class Q10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> q = new Stack<>();
        for(int i = 0; i<N; i++) {
            int newInt = Integer.parseInt(br.readLine());
            if (newInt == 0) q.pop();
            else q.push(newInt);
        }
        while(!q.isEmpty()){
            answer += q.pop();
        }
        System.out.println(answer);
    }
}
