import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] co = new int[N][2];

    for (int a = 0; a < N; a++) {
      co[a][0] = sc.nextInt();
      co[a][1] = sc.nextInt();
    }

    for (int i=0; i<N; i++) {
      int curX = co[i][0];
      int curY = co[i][1];
      for (int j=0; j<N; j++) {

        if(co[j][0] >= curX && co[j][0] <= curY) {
          if(co[j][1] > curY) {
            curY = co[j][1];
            co[i][1] = curY;
            continue;
          }
        }

        if(co[j][0] <= curX && co[j][1] <= curY) {
          curX = co[j][0];
          co[i][1] = curX;
          continue;
        }

        if(co[j][0] >= curX && co[j][1] <= curY) {

          continue;
        }

        if(co[j][0] <= curX && co[j][1] >= curY) {
          curX = co[j][0];
          curY = co[j][1];
          continue;
        }

        if(co[j][0] curX && co[j][1] curY) {
          
          continue;
        }
      }
    }

    int answer = 0;
    for(int i=0; i<N; i++) {
      System.out.println(lines[i][0]+" "+lines[i][1]);
      answer = answer + (lines[i][1] - lines[i][0]);
    }

    System.out.println(answer);
  }
}