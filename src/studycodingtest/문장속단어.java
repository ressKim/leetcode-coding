package studycodingtest;

import java.util.Scanner;

public class 문장속단어 {

  public String solution(String str) {
    String answer = "";
    int m = Integer.MIN_VALUE;
    String[] s = str.split(" ");
    for (String a : s) {
      int len = a.length();
      if (len > m) {
        m = len;
        answer = a;
      }
    }

//    int m = Integer.MIN_VALUE, pos;
//    while ((pos = str.indexOf(' ')) != -1) {
//      String tmp = str.substring(0, pos);
//      if (tmp.length() > m) {
//        m = tmp.length();
//        answer = tmp;
//      }
//      str = str.substring(pos + 1);
//    }
//    if (str.length() > m) {
//      answer = str;
//    }
    return answer;
  }

  public static void main(String[] args) {
    문장속단어 T = new 문장속단어();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }

}
