import java.io.*;
import java.util.Arrays;

class q2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        for (int i = 0; i<N; i++){
            System.out.println(numbers[i]);
        }
    }
}
