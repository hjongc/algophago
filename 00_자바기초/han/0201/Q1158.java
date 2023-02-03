import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        for(int i = 1; i<=N; i++) q.offer(i);
        while(!(q.isEmpty())){
            int tmp = q.poll();
            if (++cnt == K) {sb.append(tmp).append(", "); cnt=0; continue;}
            else q.offer(tmp);
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}
