package probl;

import java.util.HashMap;

public class 문제3 {

  /**
   *
   * @param ings 재료 정보
   * @param menu 메뉴 정보
   * @param sell 하루동안 판매 실적
   * @return
   */
  public int solution(String[] ings, String[] menu, String[] sell) {

    int answer = 0;

    HashMap<String, Integer> metaPriceMap = new HashMap<>();
    HashMap<String, Integer> menuProfitMap = new HashMap<>();

    //재료 값 map
    for (String ing : ings) {
      String[] s = ing.split(" ");
      metaPriceMap.put(s[0], Integer.valueOf(s[1]));
    }

    //메뉴당 이윤 map
    for (String s : menu) {
      String[] menuArr = s.split(" ");
      int allMetaPrice = 0;
      char[] chars = menuArr[1].toCharArray();
      for (char meta : chars) {
        allMetaPrice += metaPriceMap.get(String.valueOf(meta));
      }

      String menuName = menuArr[0];
      Integer menuProfit = Integer.parseInt(menuArr[2]) - allMetaPrice;

      menuProfitMap.put(menuName, menuProfit);
    }

    //하루당 이윤 금액 계산
    for (String s : sell) {
      String[] sellArr = s.split(" ");
      Integer profit = menuProfitMap.get(sellArr[0]);
      answer += profit * Integer.parseInt(sellArr[1]);
    }

    return answer;
  }


  public static void main(String[] args) {
    문제3 T = new 문제3();
//    String[] ings = {"r 10", "a 23", "t 124", "k 9"};
//    String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
//    String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};
    String[] ings = {"r 10", "a 23", "t 124", "k 9"};
    String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
    String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

    System.out.println("정답 = " + T.solution(ings, menu, sell));
  }
}
