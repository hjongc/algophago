import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    HashMap<String, String> map = new HashMap<>();
    for(int n=0; n<N; n++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      String k = st2.nextToken();
      String v = st2.nextToken();
      map.put(k, v);
    }
    for(int q=0; q<Q; q++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      String id = st3.nextToken();
      bw.write(map.get(id));
      bw.newLine();
    }
    bw.close();
  }
}