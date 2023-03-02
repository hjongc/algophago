package s2295;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    HashSet<Integer> sums = new HashSet<>();
    Arrays.sort(arr);

    //배열을 돌면서 최댓값보다 작은 값이 나오면 큐에 집어넣음
    for (int a = 0; a < N - 1; a++) {
      for (int b = a + 1; b < N; b++) {
           if(arr[a]+arr[b] <= arr[N-1]) sums.add(arr[a]+arr[b]);
      }
    }

    //큐에 집어넣은 값이 두 개의 합이니까 어떤 수에서 다른 수를 빼면 무조건 그 값이 나와야함

    for(int i=N-1; i>0; i++) {
      for(int j=0; j<N-1; j++) {
        //  arr[i] - arr[j] == sums의 원소이면 answer++
      }
    }
//
//    System.out.println(answer);
  }
  public static boolean BS(int[]arr, int key) {
    int n = arr.length;
    int start = 0;
    int end = arr.length - 1;
    while(start <= end) {
      int mid = (start + end) / 2;
      if(arr[mid] == key) return true;
      else if(arr[mid] > key) end = mid - 1;
      else start = mid + 1;
    }
    return false;
  }
}