package studycodingtest;

import java.util.Scanner;

public class 대소문자변환 {

  public String solution(String str) {
    String answer = "";
    for (char a : str.toCharArray()) {
      if (Character.isLowerCase(a)) {
        answer += Character.toUpperCase(a);
      } else {
        answer += Character.toLowerCase(a);
      }
    }

    //개인적으로 아스키 코드 방식은 선호하지 않음..
//    for (char a : str.toCharArray()) {
      //소문자를 대문자로 변환 - 아스키 코드 방식
//      if (a >= 97 && a < 122) {
//        answer += (char)(a - 32);
//      }
//      대문자를 소문자로 변환 - 아스키 코드 방식
//      else{
//        answer += (char)(a + 32);
//      }
//    }
    System.out.println("answer = " + answer);
    return answer;
  }

  public static void main(String[] args) {
    대소문자변환 T = new 대소문자변환();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.print(T.solution(str));
  }

}
