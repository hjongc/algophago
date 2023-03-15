package day0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_19583_싸이버개강총회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입장과 퇴장이 모두 확인된 학회원 구하기
		// 조건 1. 개강총회를 시작하기 전, 대화를 한 사람.
		// 조건 2. 개강총회가 끝나고 ~ 스트리밍이 끝날 때까지 대화한 적 있는 학회원
		
		// 24시간제이기 때문에 시간을 분으로 변환해서  
		// 시간 비교가 가능하게한다.
		
		// 24 넘어가는 경우 고려할 필요없음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] S = st.nextToken().split(":");
		String[] E = st.nextToken().split(":");
		String[] Q = st.nextToken().split(":");
		
		int sm = Integer.parseInt(S[0])*60 + Integer.parseInt(S[1]);
		int em = Integer.parseInt(E[0])*60 + Integer.parseInt(E[1]);
		int qm = Integer.parseInt(Q[0])*60 + Integer.parseInt(Q[1]);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		
		String tmp = "";
		while ((tmp = br.readLine()) != null) {
			st = new StringTokenizer(tmp);
			String[] T = st.nextToken().split(":");
			
			int tm = Integer.parseInt(T[0])*60 + Integer.parseInt(T[1]);
			
			String name = st.nextToken();
			
			// tm이 개강총회 시작하기 전이면 map에 넣는다.
			if (tm <= sm) map.put(name, false);
			
			// tm이 개강총회가 끝나고 스트리밍이 종료되기 이전이면
			// map에 해당이름이 있는지 확인하고 
			// 만약에 있다면 true로 바꿔준다.
			if (em<=tm && tm<=qm && map.containsKey(name)) map.replace(name, true);
			
		}
		
		
		int cnt = 0;
		for (String name : map.keySet()) {
			if (map.get(name)) cnt++;
		}
		System.out.println(cnt);
	}
}
