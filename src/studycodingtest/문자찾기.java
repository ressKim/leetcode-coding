package studycodingtest;

import java.util.Scanner;

public class 문자찾기 {

  public int solution(String str, char t) {
    int answer = 0;
    str = str.toUpperCase();
    t = Character.toUpperCase(t);
    System.out.println("str = " + str + ", t = " + t);

//    for (int i = 0; i < str.length(); i++) {
//      if(str.charAt(i) ==t){
//        answer++;
//      }
//    }
    for (char a : str.toCharArray()) {
      if (a == t) {
        answer++;
      }
    }

    System.out.println("answer = " + answer);
    return answer;
  }


  public static void main(String[] args) {
    문자찾기 T = new 문자찾기();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    char c = kb.next().charAt(0);
    System.out.print(T.solution(str, c));

  }

}
