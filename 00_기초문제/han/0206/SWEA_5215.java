import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int test_case = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int totalIngre = Integer.parseInt(st.nextToken());
			int totalKcal = Integer.parseInt(st.nextToken());
			int[][] total = new int[totalIngre+1][totalKcal+1];

			for (int j = 0; j<totalIngre; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int point = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				for (int k = totalIngre-1; k >= 0; k-- ) {
					for (int x = totalKcal-kcal; x >= 0; x--) {
						total[k+1][x+kcal] = Math.max(total[k][x]+point, total[k+1][x+kcal]);
					}
				}
			}
			int max = 0;
			for (int j = 1; j<=totalIngre;j++) {
				for (int k = 1; k<=totalKcal; k++ ) {
					if (total[j][k] > max) {
						max = total[j][k];
					}
					
				}
			}
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
