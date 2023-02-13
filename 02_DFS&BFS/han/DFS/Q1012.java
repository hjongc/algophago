import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        // 입력 받기 
        // grid : 배추가 있는지 판단하기 위한 이차원 정수배열
        // visited : 방문 했는지 확인하기 위한 이차원 boolean배열
        for (int i = 0; i<test_case; i++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] grid = new int[M+2][N+2];
            boolean[][] visited = new boolean[M+2][N+2];

            for (int j = 0; j<K; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                grid[a+1][b+1] = 1;
            }

            // route : 방문할 수 있는 곳을 저장하기 위한 스택
            // 어느 지점에 방문 -> 그 지점에서 방문할 수 있는 곳을 모두 스택에 넣고
            // 하나씩 빼면서 모두 방문
            Stack<set> route = new Stack<>();
            for (int j = 1; j<=M; j++) {
                for (int k = 1; k<=N; k++) {
                    if (DFS(grid, visited, j, k, route) == 1) answer++;
                    else continue;
                }
            }
            System.out.println(answer);
        }
    }

    // BFS 함수
    public static int DFS(int[][] grid, boolean[][] visited, int x, int y, Stack<set> route) {

        // 방문했던 곳이거나 배추가 없는곳 -> 바로 빠져나옴 
        if (grid[x][y] == 0 || visited[x][y]) return 0;

        // 상 하 좌 우    만약 방문하지 않았고, 배추가 있다면 방문해야 하는 곳이므로 스택에 삽입
        if (x-1>=0 && grid[x-1][y] == 1 && !visited[x-1][y]) {
            route.push(new set(x-1,y));
        }
        if (x+1<=grid.length && grid[x+1][y] == 1 && !visited[x+1][y]) {
            route.push(new set(x+1,y));
        }
        if (y-1>=0 && grid[x][y-1] == 1 && !visited[x][y-1]) {
            route.push(new set(x,y-1));
        }
        if (y+1<=grid[0].length && grid[x][y+1] == 1 && !visited[x][y+1]) {
            route.push(new set(x,y+1));
        }

        // 방문!
        visited[x][y] = true; 
        // 스택이 다 빌 때 까지 방문!
        while(!route.isEmpty()) {
            set popped = route.pop();
            DFS(grid, visited, popped.x, popped.y, route);
        }
        return 1;
    }
}
class set {
    public int x;
    public int y;
    public set (int x, int y) {
        this.x = x;
        this.y = y;
    }
}