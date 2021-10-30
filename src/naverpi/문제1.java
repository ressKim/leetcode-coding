package naverpi;

import java.util.HashMap;

public class 문제1 {

  class Solution {
    public int solution(String[] id_list, int k) {
      int answer = 0;
      HashMap<String, Integer> nameMap = new HashMap<>();
      for (String str : id_list) {
        String[] dayStrings = str.split(" ");
        int tmp = 0;
        for (String dayString : dayStrings) {
          if (nameMap.get(dayString) == null) {
            nameMap.put(dayString, 1);
          }else{
            Integer cuponCount = nameMap.get(dayString);
            if (cuponCount < k && tmp ==0) {
              cuponCount += 1;
              tmp++;
              nameMap.put(dayString, cuponCount);
            }
          }
        }
      }

      for (Integer value : nameMap.values()) {
        answer += value;
      }
      return answer;
    }
  }

}
