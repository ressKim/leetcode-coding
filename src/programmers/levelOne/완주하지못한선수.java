package programmers.levelOne;

import java.util.HashMap;

public class 완주하지못한선수 {

    static class Solution {
        public static void main(String[] args) {

//            String[] participant = {"leo", "kiki", "eden"};
            String[] participant = {"mislav", "stanko", "mislav", "ana"};
//            String[] completion= {"eden", "kiki"};
            String[] completion= {"stanko", "ana", "mislav"};
            solution(participant, completion);
        }
        public static String solution(String[] participant, String[] completion) {

            String result = "";
            HashMap<String, Integer> map = new HashMap<>();
            for (String element : participant){
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
            for (String element : completion){
                map.put(element, map.get(element) - 1);
            }
            for (String key : map.keySet()) {
                if (map.get(key) != 0){
                    result += key;
                }
            }

            return result;
        }
    }


}
