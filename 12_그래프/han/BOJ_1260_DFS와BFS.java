package han;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int nodeNum = Integer.parseInt(st.nextToken());
		int lineNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[nodeNum+1][nodeNum+1];
		boolean[][] visited3 = new boolean[nodeNum+1][nodeNum+1];
		for (int i = 0; i<lineNum; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			visited[x][y] = true;
			visited[y][x] = true;
			visited3[x][y] = true;
			visited3[y][x] = true;
		}
		DFS(visited, startNode);
		System.out.println("");
		Queue<Integer> queue = new LinkedList<>();
		BFS(visited3, startNode, queue);
	}

	public static void DFS(boolean[][] visited, int startNode) {
		Stack<Integer> stack = new Stack<>();
		if (visited[startNode][startNode]) return;
		for (int i = visited.length-1; i>=0; i--) {
			if (visited[startNode][i]) {
				stack.push(i);
			}
		}
		for (int i = 0; i<visited.length; i++) {
			visited[startNode][i] = false;
			visited[i][startNode] = false;	
		}
		visited[startNode][startNode] = true;

		System.out.print(startNode+" ");
		while(!stack.isEmpty()) {
			int newStart = stack.pop();
			DFS(visited, newStart);
		}
		
	}
	
	public static void BFS(boolean[][] visited, int startNode, Queue<Integer> queue) {
		
		if (visited[startNode][startNode]) return;
		for (int i = 1; i<visited.length; i++) {
			if (visited[startNode][i]) {
				queue.offer(i);
			}
		}
		for (int i = 0; i<visited.length; i++) {
			visited[startNode][i] = false;
			visited[i][startNode] = false;	
		}
		visited[startNode][startNode] = true;

		System.out.print(startNode+" ");
		while(!queue.isEmpty()) {
			int newStart = queue.poll();
			BFS(visited, newStart, queue);
		}
		
	}
}

