import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        char[][] grid = new char[size][size];

        for (int i = 0; i<size; i++){
            grid[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[size][size];

        int answer = 0;

        Stack<set> route = new Stack<>();
        for (int j = 0; j<size; j++) {
            for (int k = 0; k<size; k++) {
                if (DFS(grid, visited, j, k, route) == 1) answer++;
                else continue;
            }
        }
        sb.append(answer);

        visited = new boolean[size][size];

        answer = 0;

        Stack<set> route2 = new Stack<>();
        for (int j = 0; j<size; j++) {
            for (int k = 0; k<size; k++) {
                if (DFS2(grid, visited, j, k, route2) == 1) answer++;
                else continue;
            }
        }
        sb.append(" ").append(answer);
        
        System.out.println(sb);
    }

    // DFS 함수
    public static int DFS(char[][] grid,boolean[][] visited, int x, int y, Stack<set> route) {

        // 방문했던 곳이거나 배추가 없는곳 -> 바로 빠져나옴 
        if (visited[x][y]) return 0;

        char prevChar = grid[x][y];

        // 상 하 좌 우    만약 방문하지 않았고, 배추가 있다면 방문해야 하는 곳이므로 스택에 삽입
        if (x>0 && !visited[x-1][y] && grid[x-1][y] == prevChar) {
            route.push(new set(x-1,y));
        }
        if (x+2<=visited.length && !visited[x+1][y] && grid[x+1][y] == prevChar) {
            route.push(new set(x+1,y));
        }
        if (y>0 && !visited[x][y-1] && grid[x][y-1] == prevChar) {
            route.push(new set(x,y-1));
        }
        if (y+2<=visited[0].length && !visited[x][y+1] && grid[x][y+1] == prevChar) {
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

    // DFS 함수
    public static int DFS2(char[][] grid,boolean[][] visited, int x, int y, Stack<set> route) {

        // 방문했던 곳이거나 배추가 없는곳 -> 바로 빠져나옴 
        if (visited[x][y]) return 0;

        char prevChar = grid[x][y];

        if (prevChar == 'G' || prevChar == 'R') {
                // 상 하 좌 우    만약 방문하지 않았고, 배추가 있다면 방문해야 하는 곳이므로 스택에 삽입
            if (x>0 && !visited[x-1][y] && (grid[x-1][y] == 'G' || grid[x-1][y] == 'R')) {
                route.push(new set(x-1,y));
            }
            if (x+1<visited.length && !visited[x+1][y] && (grid[x+1][y] == 'G' || grid[x+1][y] == 'R')) {
                route.push(new set(x+1,y));
            }
            if (y>0 && !visited[x][y-1] && (grid[x][y-1] == 'G' || grid[x][y-1] == 'R')) {
                route.push(new set(x,y-1));
            }
            if (y+1<visited[0].length && !visited[x][y+1] && (grid[x][y+1] == 'G' || grid[x][y+1] == 'R')) {
                route.push(new set(x,y+1));
            }

            // 방문!
            visited[x][y] = true; 
            // 스택이 다 빌 때 까지 방문!
            while(!route.isEmpty()) {
                set popped = route.pop();
                DFS2(grid, visited, popped.x, popped.y, route);
            }
            return 1;
        } else {
                // 상 하 좌 우    만약 방문하지 않았고, 배추가 있다면 방문해야 하는 곳이므로 스택에 삽입
            if (x>0 && !visited[x-1][y] && grid[x-1][y] == prevChar) {
                route.push(new set(x-1,y));
            }
            if (x+1<visited.length && !visited[x+1][y] && grid[x+1][y] == prevChar) {
                route.push(new set(x+1,y));
            }
            if (y>0 && !visited[x][y-1] && grid[x][y-1] == prevChar) {
                route.push(new set(x,y-1));
            }
            if (y+1<visited[0].length && !visited[x][y+1] && grid[x][y+1] == prevChar) {
                route.push(new set(x,y+1));
            }

            // 방문!
            visited[x][y] = true; 
            // 스택이 다 빌 때 까지 방문!
            while(!route.isEmpty()) {
                set popped = route.pop();
                DFS2(grid, visited, popped.x, popped.y, route);
            }
            return 1;
        }
        
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