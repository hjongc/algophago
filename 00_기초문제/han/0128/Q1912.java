import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1912 {
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
            else if (input >= 0 && part_sum >= maximum && change) {
                maximum = part_sum;
                part_sum = 0;
                change = false;
            }
            else if (part_sum + maximum <0) {change=true; part_sum = 0;}
            else if (change && part_sum<0){
                part_sum = 0;
            }
            else if (change){
                continue;
            }
            else if (input >= 0 && part_sum >= 0) {
                maximum += part_sum;
                part_sum = 0;
            }
            else if (input >= 0 && part_sum < 0){
                continue;
            }
            else {continue;}

        }
        System.out.println(maximum);
	}
}
