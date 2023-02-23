package DP;
import java.util.Scanner;

public class BOJ_1912_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] num = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		
		/*
		 	다음 수가 주어졌어.

			만약에 현재 수로 새로 시작하는 것보다
			그전까지 같이 더하는게 더 크면 쭉 더해봐야지
			
			그런데 새로 시작하는게 더 크면
			그 전까지를 저장하고 새로 시작해서 더하는 게 낫지
			
			여기서 놓치면 안 될 건
			음수를 만나서 줄어들기 전에 저장해야한다. 
			(이럴 경우 sum을 초기화하지는 않지만 사이즈만 올려서 저장한다.)
		 
		 
		 */
		
		// 1. 현재 수까지 더한 게 큰지 -> 그대로 더하고 넘어감
		// 2. 현재 수가 큰지 -> 초기화하고 현재값 넣기
		// 3. 다음 수가 음수면 -> 줄어들기 전 값 저장하고 넘어
		
		
		int size = 0;
		dp[0] = num[0];
		
		for(int i = 1; i < n; i++) {
			if(dp[size] + num[i] < num[i]) {		// 2번 새로 시작하기
				dp[++size] = num[i];
			} else if(num[i] < 0) {					// 3번 음수면 저장하기
				//dp[++size] = dp[size] + num[i];	// 전위 후위 연산자가 앞에서부터군요
				dp[size + 1] = dp[size] + num[i];
				size++;
			} else {								// 1번 계속 더하기
				dp[size] += num[i];
			}
		}
		
		int max = dp[0];
		for(int i = 0; i <= size; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);

	}	
}