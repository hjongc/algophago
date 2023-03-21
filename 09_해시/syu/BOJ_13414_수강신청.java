import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int K = sc.nextInt();
    int L = sc.nextInt();
    HashMap<String, Integer> map = new HashMap<>();
    int i = 0;
    //이렇게 집어넣으면 input이 key, count가 value가 되어서 들어가고,
    //나중에 그 학번이 또 나오더라도 이전 count를 덮어쓰고 나중으로 적용됨
    for(int l=0; l<L; l++) {
      String input = sc.next();
      map.put(input, ++i);
    }
    //comparator를 만들어서 key를 value순으로 재정렬함
    List<String>keyList = new ArrayList<>(map.keySet());
    keyList.sort((a, b) -> map.get(a).compareTo(map.get(b)));
    int cnt = 0;
    //K개만 뽑음 근데 초과 뜨네 ㅠ
    for (String key : keyList) {
      if(cnt == K) break;
      System.out.println(key);
      cnt++;
    }
  }
}
