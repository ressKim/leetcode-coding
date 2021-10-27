package studycodingtest;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {

  public ArrayList<String> solution(int n, String[] strings) {
    ArrayList<String> answer = new ArrayList<>();
//    for (String x : strings) {
//      String tmp = new StringBuilder(x).reverse().toString();
//      answer.add(tmp);
//    }

    //직접 완전 구현 하는 방법
    for (String x : strings) {
      char[] s = x.toCharArray();
      int lt = 0;
      int rt = s.length - 1;
      while (lt < rt) {
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(s);
      answer.add(tmp);
    }
    return answer;
  }


  public static void main(String[] args) {
    단어뒤집기 T = new 단어뒤집기();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
      str[i] = kb.next();
    }
    for (String x : T.solution(n, str)) {
      System.out.println(x);
    }
  }
}
