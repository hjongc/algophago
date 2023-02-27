package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Conf {
	int x;
	int y;
	
	Conf(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 회의 개수
		int N= Integer.parseInt(st.nextToken());
		ArrayList<Conf> list = new ArrayList<>();

		// 회의 시작시간 끝시간 입력 -> 시작시간 순서대로 정렬
		for(int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			
			list.add(new Conf(x, y));
		}
		
		list.sort(new Comparator<Conf>() {
			@Override
			public int compare(Conf c1, Conf c2) {
				// 시작 시간이 같으면 끝 시간이 빠른 걸로
				if(c1.y == c2.y) {
					return (int)(c2.x - c1.x);
				} else {
					return (int) (c2.y - c1.y);
				}
			}
		});
		
		
		int cnt = 1;
		int s = list.get(N - 1).x;
		int e = list.get(N - 1).y;
		System.out.println(list.get(0).x + " " +  list.get(0).y);

		
		for(int i = 1; i < list.size(); i++) {
			// 다음 시작 할 때 cnt++
			if(list.get(i).y <= s) {
				cnt++;
				s = list.get(i).x;
				System.out.println(list.get(i).x + " " +  list.get(i).y);
			// 맨 끝일 때는 추가
			} else if(i == 0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
