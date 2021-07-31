package easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        /**
         * Runtime : 0ms
         * Memory : 36.7Mb
         */

        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        int maxSize = strs[0].length();
        while (n < maxSize) {
            char firstChar = strs[0].charAt(n);
            for (String str : strs) {
                if (str.length() <= n || firstChar != str.charAt(n)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(firstChar);
            n++;
        }
        return stringBuilder.toString();
    }
}
