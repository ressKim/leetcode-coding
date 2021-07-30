package easy;


import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        /**
         * Runtime: 17 ms
         * Memory Usage: 39.9 MB
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
        int same_value = 0;
        String[] split_strings = s.split("");
        for (int i = 0; i < split_strings.length; i++) {
            String split_string = split_strings[i];

            if (i == split_strings.length - 1) {
                result += romanMap.get(split_string);
                result += same_value;
                break;
            }

            if (romanMap.get(split_string) < romanMap.get(split_strings[i + 1])) {
                result -= romanMap.get(split_string);
                result -= same_value;
                same_value = 0;
                continue;
            } else if (romanMap.get(split_string).equals(romanMap.get(split_strings[i + 1]))) {
                same_value += romanMap.get(split_string);
                continue;
            }
            result += romanMap.get(split_string);
            result += same_value;
            same_value = 0;
        }
        return result;
    }

}
