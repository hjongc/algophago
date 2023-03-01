import java.util.Scanner;

public class BOJ_11055_가장큰증가부분수열 {
  //이거 그때도 못 풀었던것 같은데 ㅋㅋㅋ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    for(int i=0; i<N-1; i++) {
      if(arr[i] <= arr[i+1]) ;
    }
    int[] arr2 = new int[N];
    arr2[0] = arr[0];

  }
}
