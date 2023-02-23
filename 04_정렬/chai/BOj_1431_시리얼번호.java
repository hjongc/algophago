import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOj_1431_시리얼번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// Serial 객체를 담을 리스트 선언 
		List<Serial> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			
			// 각 자리수의 합 구하기 
			int numSum = 0;
			for (int j=0; j<s.length(); j++) {
				if (0<s.charAt(j)-'0' && s.charAt(j)-'0'<10) {
					numSum += s.charAt(j)-'0';
				}
			}
			Serial serial = new Serial(s, s.length(), numSum);
			list.add(serial);
		}
		
		Collections.sort(list, new Comparator<Serial>() {
			@Override
			public int compare(Serial o1, Serial o2) {
				if (o1.length < o2.length) {
					return -1;
				}
				else if (o1.length == o2.length) {
					if (o1.numSum == o2.numSum) return o1.serialNum.compareTo(o2.serialNum);
					else return Integer.compare(o1.numSum, o2.numSum);
				}
				else return 1;
				
			}
		});
		for (Serial s: list) {
			sb.append(s.serialNum).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class Serial {
		String serialNum;
		int length; // 시리얼 넘버의 길이를 저장한다.
		int numSum; // 각 자리 모든 자리수의 합을 저장한다.
		
		Serial(String serialNum, int length, int numSum) {
			this.serialNum = serialNum;
			this.length = length;
			this.numSum = numSum;
		}
	}
}


