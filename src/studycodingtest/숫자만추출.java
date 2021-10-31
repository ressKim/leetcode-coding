package studycodingtest;

import java.util.Scanner;

public class 숫자만추출 {


  private int solution(String str) {
    int answer = 0;
    //아스키 코드로 계산
    /*
    for (char x : str.toCharArray()) {
      if (x >= 48 && x <= 57) {
        answer = answer * 10 + (x - 48);
      }
    }
     */

    String tmp = "";
    for (char x : str.toCharArray()) {
      if (Character.isDigit(x)) {
        tmp += x;
      }
    }
    answer = Integer.parseInt(tmp);

    // ++ 또 사실 정규식 써도 될것같다.

    return answer;
  }


  public static void main(String[] args) {
    숫자만추출 T = new 숫자만추출();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

}
