package s1253;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    HashSet<Integer> sums = new HashSet<>();
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    for (int a = 0; a < N - 1; a++) {
      for (int b = a + 1; b < N; b++) {
           if(arr[a]+arr[b] <= arr[N-1]) sums.add(arr[a] + arr[b]);
      }
    }
    int answer = 0;

    Iterator<Integer> iter = sums.iterator();
    while(iter.hasNext()) {
      int next = iter.next();
      if(BS(arr, next)) answer++; //이진 탐색으로 모두 찾는걸 어떻게함?...
    }
    System.out.println(answer);
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