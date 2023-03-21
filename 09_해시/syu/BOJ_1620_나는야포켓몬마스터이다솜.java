import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int N = sc.nextInt();
    HashMap<String, String> map = new HashMap<>();

    String num = Integer.toString(1);
    for (int tc = 1; tc <= T; tc++) {

      String pokemon = sc.next();

			//포켓몬 이름과 넘버를 k:v쌍으로 넣고, v:k쌍으로 뒤집어서도 넣음
      map.put(pokemon, num); 
      map.put(num, pokemon);

			//숫자로 바꿔서 더하고 다시 문자로 바꿔서 재할당
      int parsednum = Integer.parseInt(num);
      num = Integer.toString(++parsednum);
    }

    for (int n = 0; n < N; n++) {
      String question = sc.next();
      String answer = map.get(question);
      System.out.println(answer);
    }
  }
}