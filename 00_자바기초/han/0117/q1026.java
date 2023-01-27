import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int elementNumber = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] iArr1 = new int[elementNumber];
		int[] iArr2 = new int[elementNumber];
		for (int i = 0; i < elementNumber; i++){
			iArr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < elementNumber; i++){
			iArr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(iArr1);
		Arrays.sort(iArr2);
		int answer = 0;
		for (int i = 0; i < elementNumber; i++){
			answer += iArr1[i] * iArr2[elementNumber-1-i];
		}
		System.out.println(answer);
    }
}
