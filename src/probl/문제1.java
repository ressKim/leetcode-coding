package probl;

public class 문제1 {


  public int[] solution(int[] arr) {

    int oneCount = 0;
    int twoCount = 0;
    int threeCount = 0;
    int maxCount = 0;

    for (int i : arr) {
      if (i == 1) {
        oneCount++;
      } else if (i == 2) {
        twoCount++;
      } else if (i == 3) {
        threeCount++;
      }
    }

    int compareOneTwo = Integer.max(oneCount, twoCount);
    maxCount = Integer.max(compareOneTwo, threeCount);

    int oneValue = maxCount - oneCount;
    int twoValue = maxCount - twoCount;
    int threeValue = maxCount - threeCount;

    int[] answer = {oneValue, twoValue, threeValue};

    return answer;
  }


  public static void main(String[] args) {
    문제1 T = new 문제1();
    int[] arr = {2, 1, 3, 1, 2, 1};

    System.out.println("정답 = " + T.solution(arr));

    System.out.println("");
  }
}
