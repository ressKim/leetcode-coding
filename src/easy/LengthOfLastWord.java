package easy;

public class LengthOfLastWord {

    /**
     * Runtime: 0ms
     * Memory : 37.2MB
     */

    public int lengthOfLastWord(String s) {

        final int firstSpace = s.indexOf(" ");
        if (firstSpace == -1) {
            return s.length();
        }
        final int length = s.length();
        int wordIndex = firstSpace;
        int lastWordLength = firstSpace;

        while (wordIndex < length) {
            int nextWordIndex = s.indexOf(" ", wordIndex + 1);
            if (nextWordIndex == -1) {
                if (wordIndex + 1 < length) {
                    return length - wordIndex -1;
                }
                return lastWordLength;
            }

            if (nextWordIndex - wordIndex != 1) {
                lastWordLength = nextWordIndex - wordIndex - 1;
            }
            wordIndex = nextWordIndex;
        }
        return lastWordLength;
    }
}
