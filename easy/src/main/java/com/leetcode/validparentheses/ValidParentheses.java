package com.leetcode.validparentheses;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author Nikolay Chechenko.
 * @since 15.05.2020
 */
public class ValidParentheses {

    private final char ROUND_BRACKET_OPEN = 40;
    private final char ROUND_BRACKET_CLOSE = 41;

    private final char SQUARE_BRACKET_OPEN = 91;
    private final char SQUARE_BRACKET_CLOSE = 93;

    private final char CURLY_BRACKET_OPEN = 123;
    private final char CURLY_BRACKET_CLOSE = 125;


    public static void main(String[] args) {
        ValidParentheses inst = new ValidParentheses();

        System.out.println("Valid : " + inst.isValid("()"));
        System.out.println("Valid : " + inst.isValid("()[]{}"));
        System.out.println("Valid : " + inst.isValid("(]"));
        System.out.println("Valid : " + inst.isValid("([)]"));
        System.out.println("Valid : " + inst.isValid("{[]}"));
        System.out.println("Valid : " + inst.isValid("]"));
    }

    public boolean isValid(String s) {
        System.out.println("Input string: " + s);
        int currentIndex = 0;
        while (currentIndex < s.length()) {
            char currentChar = s.charAt(currentIndex);
            if (isCharIsOpenBracket(currentChar)) {
                char closeVariantForBracket = getCloseVariantForBracket(currentChar);
                int closeIndex = getCloseIndex(closeVariantForBracket, currentIndex + 1, s);
                if (closeIndex == -1) {
                    return false;
                }
                currentIndex = closeIndex;
            } else if (isCharIsCloseBracket(currentChar)) {
                //lonely close
                return false;
            }
            currentIndex++;
        }
        return true;
    }

    /**
     * returns -1 if no match;
     */
    private int getCloseIndex(char closeBracket, int fromIndex, String s) {
        if (closeBracket == -1 || fromIndex > s.length()) {
            return -1;
        }
        while (fromIndex < s.length()) {
            char currentChar = s.charAt(fromIndex);
            if (isCharIsOpenBracket(currentChar)) {
                //check nested parentheses recursively
                char closeVariantForBracket = getCloseVariantForBracket(currentChar);
                int closeIndex = getCloseIndex(closeVariantForBracket, fromIndex + 1, s);
                if (closeIndex == -1) {
                    return -1;
                }
                fromIndex = closeIndex;
            }
            if (isCharIsCloseBracket(currentChar)) {
                return currentChar == closeBracket ? fromIndex : -1;
            }
            fromIndex++;
        }
        return -1;
    }

    private boolean isCharIsOpenBracket(char currentChar) {
        return currentChar == ROUND_BRACKET_OPEN ||
                currentChar == SQUARE_BRACKET_OPEN ||
                currentChar == CURLY_BRACKET_OPEN;
    }

    private boolean isCharIsCloseBracket(char currentChar) {
        return currentChar == ROUND_BRACKET_CLOSE ||
                currentChar == SQUARE_BRACKET_CLOSE ||
                currentChar == CURLY_BRACKET_CLOSE;
    }

    private char getCloseVariantForBracket(char openBracket) {
        if (openBracket == ROUND_BRACKET_OPEN) {
            return ROUND_BRACKET_CLOSE;
        } else if (openBracket == SQUARE_BRACKET_OPEN) {
            return SQUARE_BRACKET_CLOSE;
        } else if (openBracket == CURLY_BRACKET_OPEN) {
            return CURLY_BRACKET_CLOSE;
        }
        return (char) -1;
    }

}
