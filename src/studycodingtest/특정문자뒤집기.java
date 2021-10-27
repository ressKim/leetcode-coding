package studycodingtest;

import java.util.Scanner;

public class 특정문자뒤집기 {


  public String solution(String str) {
    String answer;
    char[] s = str.toCharArray();
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      if (!Character.isAlphabetic(s[left])) {
        left++;
      } else if (!Character.isAlphabetic(s[right])) {
        right--;
      } else {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        left++;
        right--;
      }
    }
    answer = String.valueOf(s);

    return answer;
  }

  public static void main(String[] args) {
    특정문자뒤집기 T = new 특정문자뒤집기();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));

  }
}
