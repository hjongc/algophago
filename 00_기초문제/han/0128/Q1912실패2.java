import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1912실패2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int maximum = Integer.parseInt(st.nextToken());
        int part_sum = 0;
        boolean change = false;
        if (maximum < 0) change=true;
        
        for (int i = 1; i<number; i++){
            int input = Integer.parseInt(st.nextToken());
            part_sum += input;
            if (input > maximum && part_sum <=0) {maximum = input; part_sum = 0;}
            else if (input >= 0 && part_sum >= 0 && change) {
                maximum = part_sum;
                part_sum = 0;
                change = false;
            }
            else if (input >= 0 && part_sum >= 0) {
                maximum += part_sum;
                part_sum = 0;
            }
            else if (change && part_sum<0){
                part_sum = input;
            }
            else if (input >= 0 && part_sum < 0){
                continue;
            }
            else if (part_sum + maximum <0) {change=true; part_sum = 0;}
            else {continue;}

        }
        System.out.println(maximum);
	}
}
// 반례
// 5
// 1 2 -10 -40 41
// 코드의 답 1
// 진짜 답 41