package studycodingtest;

import java.util.Scanner;

public class 회문문자열 {


  private String solution(String str) {
    String answer = "NO";

    /*
    str = str.toLowerCase();
    int length = str.length();
    for (int i = 0; i < length / 2; i++) {
      if (str.charAt(i) != str.charAt(length - i - 1)) {
        return answer;
      }
    }
    */

    String tmp = new StringBuilder(str).reverse().toString();
    //equalsIgnoreCase 는 대소문자 구문 없이
    if (!str.equalsIgnoreCase(tmp)) {
      return answer;
    }

    answer = "YES";
    return answer;
  }


  public static void main(String[] args) {
    회문문자열 T = new 회문문자열();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

}
