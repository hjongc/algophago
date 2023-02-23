import java.io.*;
import java.util.StringTokenizer;
public class q1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double r1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			double r2 = Double.parseDouble(st.nextToken());
			
			if (x1==x2 && y1==y2 && r1==r2) {System.out.println(-1); continue;}
			else if(x1==x2&&y1==y2) {System.out.println(0); continue;}
			
			double distance = Math.sqrt(Math.pow((x1-x2),2) + Math.pow(y1-y2, 2));
			if (distance == r1+r2) System.out.println(1);
			else if (distance == Math.abs(r1-r2)) System.out.println(1);
			else if (distance < r1+r2 && Math.abs(r1-r2) < distance)  System.out.println(2);
			else System.out.println(0);
		}
	}
}
