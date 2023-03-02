package day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 리스트를 입력받는다. 
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬해야 이분탐색 가능
		Arrays.sort(arr);
		
		int goodNum = 0; // 좋은 수 갯수를 담는 변수 
		
		// 배열에 담겨있는 수를 모두 체크한다.
		for (int i=0; i<N; i++) {
			// 각 배열마다 시작은 양 끝에서 한다.
			int left = 0;
			int right = N-1;
			
			// 반복문을 통해 앞뒤로 하나씩 줄인다.

			while (true) { 
				// i를 포함하면 안되기 때문에
				// left 혹은 right가 i라면 이동시켜준다.
				if (left == i) left++;
				else if (right == i) right--;
				
				// left가 right와 같거나 더 크다면 정지시킨다.
				if (left >= right) break;
				
				// left와 right를 더한 값이 arr[i]와 같으면 좋은 수이다.
				// 하지만 더 크다면 right를 왼쪽으로 옮겨준다.
				// 더 작다면 left를 오른쪽으로 옮겨준다.
				if (arr[left]+arr[right] > arr[i]) right--;
				else if (arr[left]+arr[right] < arr[i]) left++;
				else {
					goodNum++;
					break;
				}
			}
		}
		System.out.println(goodNum);
	}
}
