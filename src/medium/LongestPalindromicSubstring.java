package medium;

public class LongestPalindromicSubstring {

    /**
     * Runtim = 27ms
     * Memory = 39.5MB
     */

    /**
     * 처음부터 탐색하는 방법으로 했는데,
     * O(n^2) 가 나오는데 더 효율적인 방법은 없나 더 생각해보자.
     */
    public String longestPalindrome(String s) {
        final int length = s.length();
        if (length < 1 || length > 1000) return "";

        if (length < 2) return s;
        String maxResult = "";

        for (int i = 0; i < length; i++) {

            String oddString = stringCalc(s, i, i);
            String evenString = stringCalc(s, i, i + 1);
            if (oddString.length() > maxResult.length()){
                maxResult = oddString;
            }
            if (evenString.length() > maxResult.length()){
                maxResult = evenString;
            }
        }
        return maxResult;
    }

    private String stringCalc(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }
}
