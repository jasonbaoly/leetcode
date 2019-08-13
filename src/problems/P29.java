package problems;

/**
 * 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 */
public class P29 {
    static class Solution {
        public int divide(int dividend, int divisor) {
            long longDividend = Math.abs((long) dividend);
            long longDivisor = Math.abs((long) divisor);

            boolean positive = false;
            if (dividend < 0 == divisor < 0) {
                positive = true;
            }

            // special case
            if (longDivisor == 1) {
                if (positive) {
                    return longDividend > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) longDividend;
                } else {
                    return (int) -longDividend;
                }

            }

            int quotient = 0;
            long tempDivisor;

            while (longDividend >= longDivisor) {
                int innerQuotient = 1;
                tempDivisor = longDivisor;
                for (; longDividend >= tempDivisor << 1; tempDivisor <<= 1) {
                    innerQuotient <<= 1;
                }

                quotient += innerQuotient;
                longDividend -= tempDivisor;
            }

            return positive ? quotient : -quotient;
        }
    }
}

