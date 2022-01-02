package studycodingtest.array;

import java.util.Scanner;

/**
 * 나보다 큰 사람만 보인다는 취지.. 문제가 좋진 않다.
 */
public class 보이는학생 {

  public int solution(int n, int[] arr) {
    int answer = 1;
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[i - 1]) {
        answer++;
        max = arr[i];
      }
    }

    System.out.println("answer = " + answer);
    return answer;
  }

  public static void main(String[] args) {
    보이는학생 T = new 보이는학생();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }


}
