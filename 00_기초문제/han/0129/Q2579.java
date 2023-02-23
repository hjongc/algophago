import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q2579 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] twoTake = new int[N+1];
        int[] oneTake = new int[N+1];
        int[] notTake = new int[N+1];
        int[] inputArr = new int[N+1];
        for (int i = 1; i<N+1; i++){
            inputArr[i] = Integer.parseInt(br.readLine());
        }
        oneTake[0] = inputArr[N];
        twoTake[0] = inputArr[N];
        notTake[0] = inputArr[N];
        for (int i = 1; i<N+1; i++){
            int input = inputArr[N-i];
            notTake[i] = Math.max(oneTake[i-1], twoTake[i-1]);
            oneTake[i] = notTake[i-1] + input;
            twoTake[i] = oneTake[i-1] + input;
            if (i==2) twoTake[i] = 0;
        }
        int maximum = Math.max(Math.max(oneTake[N-1],twoTake[N-1]),notTake[N-1]);
        System.out.println(maximum);
	}
}
