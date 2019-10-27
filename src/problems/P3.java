package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class P3 {
    public static int lengthOfLongestSubstring(String s) {
        int step = 0, max = -1;
        Map<Character, Integer> had = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (step != max && step + s.length() - i <= max) {
                break;
            }
            if (had.containsKey(s.charAt(i)) && had.get(s.charAt(i)) >= i - step) {
                step = i - had.get(s.charAt(i));
            } else {
                step++;
                if (step > max) {
                    max = step;
                }
            }
            had.put(s.charAt(i), i);
        }
        return max == -1 ? 0 : max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("wobgrovw"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
