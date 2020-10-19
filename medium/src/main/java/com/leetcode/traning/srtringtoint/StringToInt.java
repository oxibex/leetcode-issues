package com.leetcode.traning.srtringtoint;

/**
 *  Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 *
 * @author Nikolay Chechenko.
 * @since 06.05.2020
 */
public class StringToInt {

    private final int MIN_DIGIT_CHAR = 48;
    private final int MAX_DIGIT_CHAR = 57;
    private final int MINUS_SIGN_CHAR = 45;
    private final int PLUS_SIGN_CHAR = 43;

    public static void main(String[] args) {
        StringToInt instance = new StringToInt();
        System.out.println(instance.myAtoi("+13"));
        System.out.println(instance.myAtoi("-"));
        System.out.println(instance.myAtoi("42"));
        System.out.println(instance.myAtoi("   -42"));
        System.out.println(instance.myAtoi("4193 with words"));
        System.out.println(instance.myAtoi("words and 987"));
        System.out.println(instance.myAtoi(""));
        System.out.println(instance.myAtoi("      "));

        System.out.println("Input : " + Integer.MAX_VALUE + "78 : " + instance.myAtoi(Integer.MAX_VALUE + "78 "));
        System.out.println("Input : " + Integer.MIN_VALUE + "78 : " + instance.myAtoi(Integer.MIN_VALUE + "78 "));
    }

    public int myAtoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        String trimmedString = str.trim();
        if(trimmedString.isEmpty()) {
            return 0;
        }

        //handle first sign char
        char firstChar = trimmedString.charAt(0);
        boolean isMinus = isMinus(firstChar);

        if(isMinus || isPlus(firstChar)) {
            trimmedString = trimmedString.substring(1);
            if(trimmedString.isEmpty()) {
                return 0;
            }
            firstChar = trimmedString.charAt(0);
        }

        if(isDigit(firstChar)) {
            int lastDigitIndex = getLastDigitIndex(trimmedString);

            String integerString = trimmedString.substring(0, lastDigitIndex + 1);
            try {
                Integer convertedValue = Integer.valueOf(integerString);
                return isMinus ? -convertedValue : convertedValue;
            }catch (NumberFormatException e) {
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }else {
            return 0;
        }
    }

    private int getLastDigitIndex(String trimmedString) {
        for (int i = 1; i < trimmedString.length(); i++) {
            char nextChar = trimmedString.charAt(i);
            if(!isDigit(nextChar)) {
               return i - 1;
            }
        }
        return trimmedString.length() - 1;
    }

    private boolean isMinus(char c) {
        return c == MINUS_SIGN_CHAR;
    }

    private boolean isPlus(char c) {
        return  c == PLUS_SIGN_CHAR;
    }

    private boolean isDigit(char c) {
        return c >= MIN_DIGIT_CHAR && c <= MAX_DIGIT_CHAR;
    }

}
