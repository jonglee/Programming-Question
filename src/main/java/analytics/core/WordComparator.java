package analytics.core;

import java.util.Comparator;

/**
 * A comparitor to first compare the lengh of the string, then by the ASCII order of each character
 *
 * e.g.:
 * "a" should come before "ab" due to a shorter Lengh
 * "The" is before "the" because "T" is less than "t" in the ASCII table
 * 
 */
class WordComparator implements Comparator<String> {

    @Override
    public int compare(String s, String s1) {
        //handle null and ""
        if (isNullOrEmpty(s)) return -1;
        if (isNullOrEmpty(s1)) return 1;

        //compare length
        int len = s.length();
        int len1 = s1.length();

        int delta = len - len1;
        //different len, bingo
        if (delta != 0)
            return delta;

        //same length, have to go through the character comparison
        for (int i = 0; i < len; i++) {
            delta = convertCharToAscii(s.charAt(i)) - convertCharToAscii(s1.charAt(i));
            if (delta != 0) return delta;
        }


        //after all, it seems they are equal
        return 0;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    private static int convertCharToAscii(char c) {
        //review: how about multi-bytes character?
        return (int) c;
    }
}
