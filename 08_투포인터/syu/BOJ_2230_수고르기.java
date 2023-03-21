package b2230;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long M = sc.nextInt();
    long[]arr = new long[N];
    for(int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    } //입력 받아옴
    //정렬
    Arrays.sort(arr);

    //포인터 2
    int p2 = 0;
    //최솟값을 일단 받아올 수 있는 최대로 설정
    long min = 2000000000;
    //포인터 1을 이동시킴
    for(int p1 = 0; p1 < N; p1++) {
      //p2가 N-1까지 움직일 수 있음
      //만약 두 수의 차가 M보다 작으면 (찾는 값이 아니면) 포인터 2를 한 칸 이동시킴
      while(p2 < N && arr[p2] - arr[p1] < M ) p2++;
      //포인터 2가 배열을 넘어가면 스톱
      if(p2 == N) break;
      //최솟값은 지금 최소와 두 수의 차 중 작은 것
      min = Math.min(min, arr[p2] - arr[p1]);
    }
    //출력
    System.out.println(min);
  }
}