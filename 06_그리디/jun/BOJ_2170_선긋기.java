package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

	
// 클래스는 위에 쓰는 게 편하겠구나
class Point {
	long x;
	long y;
	
	Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
	
public class BOJ_2170_선긋기 {
	// 메인함수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 선 긋는 두 점 입력
		int N= Integer.parseInt(st.nextToken());
		ArrayList<Point> lines = new ArrayList<>();

		// 두 점 입력하고 x순서대로 정렬
		for(int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st1.nextToken());
			long y = Long.parseLong(st1.nextToken());
			
			lines.add(new Point(x, y));
		}
		
		lines.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x) {
					return (int)(o1.y - o2.y);
				} else {
					return (int) (o1.x - o2.x);
				}
			}
		});
		
		
		long s = lines.get(0).x;
		long e = lines.get(0).y;
		long sum = e - s;
		
		for(int i = 1; i < lines.size(); i++) {
			long ns = lines.get(i).x;
			long ne = lines.get(i).y;
			
			// 다음 시작점이 현재 끝점보다 크면
			if(ns > e) {
				// 새로운 선 길이 sum에 더함
				sum += ne - ns;
				s = ns;
				e = ne;
			
			// 다음 시작점이 현재 선 사이에 있으면(당연함 else해도 됨)
			} else if(ns <= e && ns >= s){
				
				// 그런데 다음 끝점이 현재 끝점 보다 클때만 길이변화
				// else 다음 끝점이 현재 끝점보다 작으면 변화없음
				if(ne >= e) {
					sum += ne - e;
					e = ne;
				}
			}
		}
		
		System.out.println(sum);
	}
	
}
