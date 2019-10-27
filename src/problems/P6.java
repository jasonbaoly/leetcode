package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class P6 {


    public static void main(String[] args) {
//        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("AB", 1));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> temp = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            temp.add(i, new StringBuilder());
        }

        int cur = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            temp.get(cur).append(s.charAt(i));

            if (cur == 0) {
                flag = 1;
            }
            if (cur == numRows - 1) {
                flag = -1;
            }
            cur += flag;
        }

        for (int i = 1; i < temp.size(); i++) {
            temp.get(0).append(temp.get(i));
        }
        return new String(temp.get(0));
    }
}
