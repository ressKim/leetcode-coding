package easy;


import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        /**
         * Runtime: 14 ms
         * Memory Usage: 39.6 MB
         */
        HashMap<String, Integer> romanMap = new HashMap<>();

        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        int result = 0;

        String[] split_strings = s.split("");

        int[] int_arr = new int[split_strings.length];

        for (int i = 0; i < split_strings.length; i++) {
            int_arr[i] =romanMap.get(split_strings[i]);
        }

        for(int i = 0; i< int_arr.length-1; i++){
            if (int_arr[i] < int_arr[i + 1]) {
                result -= int_arr[i];
                continue;
            }
            result += int_arr[i];
        }
        result += int_arr[split_strings.length-1];
        return result;
    }

}
