package graph;

//재귀함수(스택프레임)
public class 재귀함수 {

  public void DFS(int n) {
    if (n == 0) {
      return;
    } else {
      System.out.println(n);
      DFS(n - 1);
      System.out.print(n + " ");
    }
  }

  public static void main(String[] args) {
    재귀함수 T = new 재귀함수();
    T.DFS(3);
  }

}
