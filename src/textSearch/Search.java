package textSearch;

public class Search {

    static private int executionTimes = 0;

    public static int getExecutionTimes() {
        return executionTimes;
    }

    public static int bruteForce(String text, String pattern) {
        executionTimes = 0;
        int textSize = text.length();
        int patternSize = pattern.length();
        int i = 0;
        while (i < textSize - patternSize + 1) {
            int patternPosition = 0;
            executionTimes++;
            while ((patternPosition < patternSize) && (pattern.charAt(patternPosition) == text.charAt(i + patternPosition))) {
                patternPosition++;
                executionTimes++;
            }
            if (patternPosition == patternSize) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int bmhs(String text, String pattern) {
        executionTimes = 0;
        final int ASCII = 256;
        int textSize = text.length();
        int patternSize = pattern.length();
        int init = 0;
        int[] jumps = new int[ASCII];
        for (int i = 0; i < ASCII; i++) {
            jumps[i] = patternSize + 1;
        }
        for (int i = 0; i < patternSize; i++) {
            int position = pattern.charAt(i);
            jumps[position] = patternSize - i;
        }
        executionTimes += ASCII + patternSize;
        while (init < textSize - patternSize + 1) {
            int patternPosition = 0;
            executionTimes++;
            while ((patternPosition < patternSize) && (pattern.charAt(patternPosition) == text.charAt(init + patternPosition))) {
                patternPosition++;
                executionTimes++;
            }
            if (patternPosition == patternSize) {
                return init;
            }
            int word =  text.charAt(init + patternSize);
            init += jumps[word];
        }
        return -1;
    }
}
