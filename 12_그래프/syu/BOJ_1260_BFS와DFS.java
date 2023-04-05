package b1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> Q;
    static boolean[] visitedB;
    static boolean[] visitedD;
    static int[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        adj = new int[N+1][N+1];
        visitedB = new boolean[N+1];
        visitedD = new boolean[N+1];

        for(int m=0; m<M; m++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u][v] = adj[v][u] = 1;
        }
        DFS(V);
        System.out.println();
        BFS(V);


    }

    public static void DFS(int v) {
        visitedD[v] = true;
        System.out.print(v+" ");
        for(int i=1; i<adj.length; i++) if(!visitedD[i] && adj[v][i] == 1) DFS(i);
    }

    public static void BFS(int v) {
        Q = new LinkedList<>();
        Q.add(v);
        visitedB[v] = true;

        while(!Q.isEmpty()) {
            int cur = Q.poll();
            System.out.print(cur+" ");
            for(int i=1; i<adj.length; i++) {
                if(!visitedB[i] && adj[cur][i] == 1) {
                    Q.add(i);
                    visitedB[i] = true;
                }
            }

        }

    }
}
