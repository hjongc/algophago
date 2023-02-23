package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        /*

     * 놀라운건... 사실 자두나무 시작위치(1)이 설정되어 있고
     * 바꾸면 무조건 1->2, 2->1이므로
     * 배열이 1차원이여도 문제없다는것...
     * 
     * 더 놀라운건
     * 2차원 배열이랑 비교했을 때와
     * 메모리 차이가 거의 없다는거 ㅋㅋ
     */
    
    // 총 W번까지 위치를 바꿀 수 있으므로, 0번 바꾸기~W번 바꾸기까지 표현할
    // W+1크기의 배열 jadu
    // 각 index에서의 배열값은 W번 바꾸었을 때의 최대 자두 섭취량을 의미한다
    int[] jadu = new int[W+1];
    
    // 자두가 떨어지는 횟수 T회
    for (int i = 1; i<=T; i++) {
        int input = Integer.parseInt(br.readLine());
        
        // 만약 1번 위치에서 자두가 떨어진다면
        // 1. 가만히 있어서 먹거나
        // 2. 움직여서 먹거나
        // 3. 가만히 있어서 못먹음
        // 4. 움직여서 못먹거나
        // 1,2번 경우는 짝수번 움직였을 때
        // 3,4번 경우는 홀수번 움직였을 때
        if (input == 1) {
            for (int j = W; j>=0; j--) {
                
                // 짝수 (2N)번 움직인 경우
                // 짝수 (2N)번 움직인 경우의 최대값에 1을 더해주거나 (가만히 있어서 먹음)
                // 홀수 (2N-1)번 움직인 경우의 최대값에 1을 더해줌 (움직여서 먹음)
                if(j % 2 == 0) {
                    jadu[j]++;
                    if (j>0) jadu[j] = Math.max(jadu[j-1]+1, jadu[j]);
                    
                    // 홀수 (2N+1)번 움직인 경우
                    // 먹지 못하거나 (가만히 있어서 못먹음) 
                    // 짝수 (2N)번 움직인 경우의 값도 가능 (움직여서 못먹음)
                } else {
                    jadu[j] = Math.max(jadu[j], jadu[j-1]);
                }
            }
            
            //vice versa
        } else {
            for (int j = W; j>=0; j--) {
                if (j % 2 == 0) {
                    if (j > 0)
                    jadu[j] = Math.max(jadu[j], jadu[j-1]);
                } else {
                    jadu[j]++;
                    jadu[j] = Math.max(jadu[j-1]+1, jadu[j]);
                }
            }
        }
    }
    
    // 최대값 출력
    int max = 0;
    for (int i = 0; i<=W; i++) {
        if(max < jadu[i]) max = jadu[i];
    }
    System.out.println(max);
    
}
}