import java.util.Scanner;

public class BOJ_12852_1로만들기2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N+1];
    int[] tracking = new int[N+1];
    //dp 배열 arr, 값 트래킹 배열 tracking
      for(int i=2; i<N+1; i++) {
        //일단 그 수에 1 더해서 올 수 있음
        arr[i] = arr[i - 1] + 1;
        tracking[i] = i-1;

        //2로 나눠지면 그 전 수에 2를 곱해서 i로 올 수 있는데, 그게 1 더해서 온거보다 값이 작으면 최적 루트이므로 대체
        if (i % 2 == 0 && arr[i] > arr[i/2]+1) {
          arr[i] = arr[i / 2] + 1;
          //트래킹 배열에 그 값을 집어넣음.
          // i에서 1로 갈 때는 i/2로 가는게 제일 괜찮단 의미
          tracking[i] = i/2;
        }
        //3으로 나눠지면 그 전 수에 3을 곱해서 올 수 있는데, 그게 1 더해서 온거나 2로 곱해서 온거보다 값이 작으면 최적 루트이므로 대체
        if (i % 3 == 0 && arr[i] > arr[i/3]+1) {
          arr[i] = arr[i / 3] + 1;
          //트래킹 배열에 그 값을 집어넣음
          // i에서 1로 갈 때는 i/3로 가는게 제일 괜찮단 의미
          tracking[i] = i/3;
        }
      }
      int current = N; //경로를 쭉 뽑아야 되니까 이렇게 설정
      System.out.println(arr[N]); //일단 횟수 출력해주고
      for(int i=0; i<N; i++) { //10 -> 9 -> 3 -> 1 가는 과정을 뽑아줘야함
        if(current == 0) break;
        System.out.print(current+" ");
        current = tracking[current]; //tracking[i]는 1로 가는 최적 과정을 알려주니까
        //current를 계속 대체하면서 반복문 돌면 됨
      }
  }
}
