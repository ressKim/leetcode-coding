package graph;

public class 팩토리얼 {
  //재귀로 구현

  public static void main(String[] args) {
    팩토리얼 T = new 팩토리얼();
    System.out.println(T.DFS(5));
  }

  private int DFS(int i) {
    if (i == 1) {
      return 1;
    } else {
      return i * DFS(i - 1);
    }
  }
}
