import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11656_접미사배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int sLen = s.length();
		
		String[] sArr = new String[sLen];
		
		// 접미사를 모두 구한다.
		for (int i=0; i<sLen; i++) {
			String tmp = "";
			for (int j=i; j<sLen; j++) {
				tmp += s.charAt(j);
			}
			sArr[i] = tmp;
		}
		
		// Arrays.sort() 사용한다.
		Arrays.sort(sArr);
		
		for (int i=0; i<sLen; i++) {
		 	 
		 	sb.append(sArr[i]+"\n"); 
		}
		System.out.println(sb);
		
		// 더 빠른 방법 없을까? 
//		for (int i = 0; i < slist.length; i++) {
//            slist[i] = s.substring(i, s.length());
//        }
	}
}
