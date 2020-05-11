package com.leetcode.romantoint;

import java.util.List;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @author Nikolay Chechenko.
 * @since 11.05.2020
 */
public class RomanToInteger {

    private Map<String, Integer> romaMap = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    private final List<String> substractionPatterns = List.of("IV", "IX", "XL", "XC", "CD", "CM");

    public static void main(String[] args) {
        RomanToInteger inst = new RomanToInteger();
        System.out.println("III - " + inst.romanToInt("III"));
        System.out.println("IV - " + inst.romanToInt("IV"));
        System.out.println("IX - " + inst.romanToInt("IX"));
        System.out.println("LVIII - " + inst.romanToInt("LVIII"));
        System.out.println("MCMXCIV - " + inst.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int accumulator = 0;
        int currentIndex = 0;
        while (currentIndex < s.length()) {

            String currentSymbol = Character.toString(s.charAt(currentIndex));
            String nexSymbol = currentIndex + 1 < s.length() ?
                    Character.toString(s.charAt(currentIndex + 1)) : null;

            if (nexSymbol != null) {
                if (substractionPatterns.contains(currentSymbol + nexSymbol)) {
                    accumulator += romaMap.get(nexSymbol) - romaMap.get(currentSymbol);
                    currentIndex = currentIndex + 2;
                    continue;
                }
            }
            accumulator += romaMap.get(currentSymbol);
            currentIndex++;
        }
        return accumulator;
    }

}
