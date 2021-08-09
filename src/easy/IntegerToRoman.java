package easy;

import java.util.HashMap;

public class IntegerToRoman {

    /**
     * Runtime = 4ms
     * Memory = 38.2MB
     */
    public String intToRoman(int num) {
        if (1 > num || 4000 <= num) return "";

        final String[] romanArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] intArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < intArr.length; index++) {
            if (intArr[index] <= num) {
                while (intArr[index] <= num) {
                    result.append(romanArr[index]);
                    num -= intArr[index];
                }
            }
        }

        return result.toString();
    }
}
