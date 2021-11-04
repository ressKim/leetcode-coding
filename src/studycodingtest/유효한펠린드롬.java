package studycodingtest;

import java.util.Scanner;

public class 유효한펠린드롬 {

  private String solution(String str) {
    String answer = "NO";
    //정규식을 사용하기 위해 replaceAll 사용
    str = str.toLowerCase().replaceAll("[^A-Z]", "");
    System.out.println("str  == " + str);
    String tmp = new StringBuilder(str).reverse().toString();
    if (str.equals(tmp)) {
      answer = "YES";
    }
    return answer;
  }


  public static void main(String[] args) {
    유효한펠린드롬 T = new 유효한펠린드롬();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

}
