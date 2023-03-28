package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1941_소문난칠공주 {
	
	static char[][] map;
	static boolean[][] isVisited;
	static int ans;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][0];
		isVisited = new boolean[5][5];
		
		for (int i = 0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		
		int[][] coord = new int[7][2];
		
		int count = 0;
		int cnt;
		for (int a = 0; a<19; a++) {
			coord[0][0] = a/5;
			coord[0][1] = a%5;
			cnt = (map[a/5][a%5] == 'S') ? 1 : 0;
			int count1 = count + cnt;
			for (int b = a+1; b<20; b++) {
				coord[1][0] = b/5;
				coord[1][1] = b%5;
				cnt = (map[b/5][b%5] == 'S') ? 1 : 0;
				int count2 = count1 + cnt;
				for (int c = b+1; c<21; c++) {
					coord[2][0] = c/5;
					coord[2][1] = c%5;
					cnt = (map[c/5][c%5] == 'S') ? 1 : 0;
					int count3 = count2 + cnt;
					for (int d = c+1; d<22; d++) {
						coord[3][0] = d/5;
						coord[3][1] = d%5;
						cnt = (map[d/5][d%5] == 'S') ? 1 : 0;
						int count4 = count3 + cnt;
						if (count4 == 0) continue;
						for (int e = d+1; e<23; e++) {
							coord[4][0] = e/5;
							coord[4][1] = e%5;
							cnt = (map[e/5][e%5] == 'S') ? 1 : 0;
							int count5 = count4 + cnt;
							if (count5 == 1) continue;
							for (int f = e+1; f<24; f++) {
								coord[5][0] = f/5;
								coord[5][1] = f%5;
								cnt = (map[f/5][f%5] == 'S') ? 1 : 0;
								int count6 = count5 + cnt;
								if (count6 == 2) continue;
								here: for (int g = f+1; g<25; g++) {
									coord[6][0] = g/5;
									coord[6][1] = g%5;
									cnt = (map[g/5][g%5] == 'S') ? 1 : 0;
									int count7 = count6 + cnt;
									if (count7 == 3) continue;
									boolean[] connected = new boolean[7];
									connected[0] = true;
									for (int z = 0; z<7; z++) {
										for (int i = 0; i<7; i++) {
											if (!connected[i]) continue;
											for (int j = 0; j<7; j++) {
												if (i == j) continue;
												if (connected[j]) continue;
												if (isClose(coord[i][0], coord[i][1], coord[j][0], coord[j][1])) {
													connected[j] = true;
													
												}
											}
										}
									}
									
									for (int i = 0; i<7; i++) {
										if (!connected[i]) continue here;
									}
									ans++;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	
	private static boolean isClose(int x1, int y1, int x2, int y2) {
		return ((x1==x2 && (y2-y1 == 1 || y2-y1 == -1)) || (y1==y2 && (x2-x1 == 1 || x2-x1 == -1)));
	}
}
