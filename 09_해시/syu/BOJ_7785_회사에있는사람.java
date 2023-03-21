import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    HashMap<String, String> map = new HashMap<>();
    for(int n=0; n<N; n++) {
			//leave가 나오면 map에서 해당하는 key에 해당하는 값을 빼고
			//그렇지 않으면 map에 집어넣음
      String key = sc.next();
      String value = sc.next();
      if(value.equals("leave")) map.remove(key);
      else map.put(key, value);
    }
		//맵에서 key만 가져온 arrayList
    List<String> keyList = new ArrayList<>(map.keySet());

		//arrayList를 사전 역순 정렬해서 key를 모두 출력
    keyList.sort(Comparator.reverseOrder());
    for (String key: keyList) {
      System.out.println(key);
    }
  }
}