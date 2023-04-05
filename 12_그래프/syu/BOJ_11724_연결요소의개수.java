package b11724;

import java.util.*;

public class Main {
    static Queue<Integer> Q;
    static boolean[] visited;
    static int[][] adj;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        adj = new int[N+1][N+1];
        visited = new boolean[N+1];
        cnt = 0;

        for(int m=0; m<M; m++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        for(int r=1; r<N+1; r++) {
            if(visited[r]) continue;
            cnt++;
            BFS(r);
        }
        System.out.println(cnt);
    }


    public static void BFS(int cur) {
        Q = new LinkedList<>();
        Q.add(cur);

        visited[cur] = true;
        while(!Q.isEmpty()) {
            int c = Q.poll();
            for(int i=0; i<adj.length; i++) {
                if(!visited[i] && adj[c][i] == 1) {
                    Q.add(i);
                    visited[i] = true;
                }
            }

        }

    }
}
