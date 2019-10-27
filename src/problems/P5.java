package problems;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class P5 {
    public static String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        int ff = 0, fl = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int f = i, l = i;
            while (l < s.length() - 1 && s.charAt(l) == s.charAt(l + 1)) {
                l++;
            }
            do {

                if (f == 0 || l == s.length() - 1 || s.charAt(f - 1) != s.charAt(l + 1)) {
                    break;
                }
                f--;
                l++;

            } while (f > 0 && l < s.length() - 1 && s.charAt(f) == s.charAt(l));

            if (l > i && l - f > fl - ff) {
                ff = f;
                fl = l;
            }
        }
        return s.substring(ff, fl + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));
    }
}
