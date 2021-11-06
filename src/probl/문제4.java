package probl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 문제4 {

  public int[] solution(String s) {

    char[] charArr = s.toCharArray();
    Queue<String> sortQueue = new LinkedList<>();
    for (char c : charArr) {
      sortQueue.offer(String.valueOf(c));
    }

    //queue 에 넣어서 첫글자, 끝글자 다를때 까지 정렬
    boolean tmp = true;
    String val = "";
    while (tmp) {
      String getFirstString = sortQueue.poll();
      sortQueue.offer(getFirstString);
      String getSecondString = sortQueue.peek();
      if (!getFirstString.equals(getSecondString)) {
        while (!sortQueue.isEmpty()) {
          val += sortQueue.poll();
        }
        tmp = false;
      }
    }

    //같은 글자 갯수끼리 +
    ArrayList<Integer> countList = new ArrayList<>();
    int countValue = 1;
    for (int i = 0; i < val.length() - 2; i++) {
      if (val.charAt(i) == val.charAt(i + 1)) {
        countValue++;
      } else {
        countList.add(countValue);
        countValue = 1;
      }
    }
    //마지막 문자 더하기 **
    if (val.charAt(val.length() - 2) == val.charAt(val.length() - 1)) {
      countValue++;
      countList.add(countValue);
    } else {
      countList.add(countValue);
      countList.add(1);
    }

    int[] answer = countList.stream().mapToInt(Integer::intValue).toArray();

    Arrays.sort(answer);
    return answer;
  }


  public static void main(String[] args) {
    문제4 T = new 문제4();
//    String val = "aaabbaaa";
//    String val = "wowwow";
    String val = "aabbca";

    System.out.println("정답 = " + T.solution(val));

  }
}
