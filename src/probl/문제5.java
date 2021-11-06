package probl;

public class 문제5 {

  public int[][] solution(int rows, int columns) {

    int[][] answer = new int[rows][columns];
    int[][] tempAnswer = new int[rows][columns];

    //roundCount 가 계속 증가하면 멈추게 설계 필요
    int tmp = 1;
    int row = 0;
    int maxRow = rows;
    int column = 0;
    int maxColumn = columns;

    int loopZeroCount = 0;
    int maxZeroCount = 0;
    boolean loopCheck = true;
    answer[row][column] = tmp;
    tempAnswer[row][column] = tmp;
    while (loopCheck) {
      if (tmp % 2 == 0) {
        if (row == maxRow - 1) {
          if (loopZeroCount == 0) {
            loopCheck = false;
            break;
          } else {
            loopZeroCount = 0;
            for (int i = 0; i < tempAnswer.length; i++) {
              System.arraycopy(tempAnswer[i], 0, answer[i], 0, tempAnswer[i].length);
            }
          }
          row = 0;
        } else {
          row++;
        }

        if (tempAnswer[row][column] == 0) {
          loopZeroCount++;
          maxZeroCount++;
        }
        tempAnswer[row][column] = ++tmp;
        if (maxZeroCount >= maxRow * maxColumn -1) {
          for (int i = 0; i < tempAnswer.length; i++) {
            System.arraycopy(tempAnswer[i], 0, answer[i], 0, tempAnswer[i].length);
          }
          break;
        }
      } else {
        if (column == maxColumn - 1) {
          if (loopZeroCount == 0) {
            loopCheck = false;
            break;
          } else {
            loopZeroCount = 0;
            for (int i = 0; i < tempAnswer.length; i++) {
              System.arraycopy(tempAnswer[i], 0, answer[i], 0, tempAnswer[i].length);
            }
          }
          column = 0;
        } else {
          column++;
        }
        if (tempAnswer[row][column] == 0) {
          loopZeroCount++;
          maxZeroCount++;
        }

        tempAnswer[row][column] = ++tmp;
        if (maxZeroCount >= maxRow * maxColumn - 1) {
          for (int i = 0; i < tempAnswer.length; i++) {
            System.arraycopy(tempAnswer[i], 0, answer[i], 0, tempAnswer[i].length);
          }
          break;
        }
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    문제5 T = new 문제5();
    int rows = 3;
    int columns = 3;
    System.out.println("정답 = " + T.solution(rows, columns));

    //[[8,2,13,14]
    // [16,10,4,15]
    // [17,11,12,6]]

    //[[1,2,0]
    //,[0,3,4]
    //,[6,0,5]]
  }
}
