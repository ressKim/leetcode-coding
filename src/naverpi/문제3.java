package naverpi;

import java.util.*;

public class 문제3 {

  class Solution {

    public String[] solution(String[] logs) {
      HashMap<String, HashMap<String, String>> examNumMap = new HashMap<>();
      HashMap<String, Integer> countProblem = new HashMap<>();
      HashMap<String, Integer> answerMap = new HashMap<>();

      /**
       * 분리해서 HashMap<String, HashMap<String, String>> 에 주입
       */
      for (String log : logs) {
        String[] split = log.split(" ");
        //split size 는 항상 3
        if (examNumMap.get(split[0]) == null) {
          HashMap<String, String> qnaMap = new HashMap<>();
          qnaMap.put(split[1], split[2]);
          examNumMap.put(split[0], qnaMap);

          countProblem.put(split[0], 1);
        } else {
          HashMap<String, String> getNumMap = examNumMap.get(split[0]);
          getNumMap.put(split[1], split[2]);
          examNumMap.put(split[0], getNumMap);

          Integer count = countProblem.get(split[0]);
          count++;
          countProblem.put(split[0], count);
        }
      }
      /**
       * size 5 미만인것들 search 대상에서 제외
       */
      ArrayList<String> keys = new ArrayList<>();
      Set<String> stringSet = countProblem.keySet();
      for (String s : stringSet) {
        if (countProblem.get(s) >= 5) {
          keys.add(s);
        }
      }
      if (keys.size() == 0) {
        return new String[]{"None"};
      }

      /**
       * 각각의 HashMap들이 일치하는지 비교(완전동등하다면 부정행위자에 추가)
       */
      int keySize = keys.size();
      for (int i = 0; keySize - 1 > i; i++) {

        int tmp = i + 1;
        HashMap<String, String> stringHashMap0 = examNumMap.get(keys.get(i));
        while (keySize > tmp) {
          String s = keys.get(tmp);
          HashMap<String, String> stringHashMap1 = examNumMap.get(s);
          if (stringHashMap0.equals(stringHashMap1)) {
            answerMap.putIfAbsent(keys.get(i), 1);
            answerMap.putIfAbsent(keys.get(tmp), 1);
          }
          tmp++;
        }
      }
      /**
       * 값이 비어있으면 none
       */
      if (answerMap.isEmpty()) {
        return new String[]{"None"};
      }
      /**
       * 아니라면 형식에 맞게 추가 후 정렬
       */
      Set<String> strings = answerMap.keySet();
      String[] answer = strings.toArray(new String[0]);
      Arrays.sort(answer);
      return answer;
    }
  }

}
