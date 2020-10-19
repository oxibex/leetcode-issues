package com.leetcode.traning.longestpalindromic;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author Nikolay Chechenko.
 * @since 05.05.2020
 */
public class LongestPalindromic {

    public static void main(String[] args) {
        LongestPalindromic instance = new LongestPalindromic();

        String result = instance.longestPalindrome("bb");
        System.out.println("bb - " + result);

        result = instance.longestPalindrome("ac");
        System.out.println("ac - " + result);

        result = instance.longestPalindrome("babad");
        System.out.println("babad - " + result);

        result = instance.longestPalindrome("cbbd");
        System.out.println("cbbd - " + result);

        result = instance.longestPalindrome("aabcdeedcbabc");
        System.out.println("aabcdeedcbabc - " + result);

        result = instance.longestPalindrome("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "ccccccccccccccccccccccccccccccc");
        System.out.println("too many 'C' - " + result);

    }

    public String longestPalindrome(String s) {
        String longestPalindromic = "";

        for (int i = 0; i < s.length(); i++) {
            String fullSubstring = s.substring(i);
            if(longestPalindromic.length() < fullSubstring.length() &&
                    isPalindromic(fullSubstring)){
                return fullSubstring;
            }
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindromic(substring) && substring.length() > longestPalindromic.length()) {
                    longestPalindromic = substring;
                }
            }
        }
        return longestPalindromic;
    }

    private boolean isPalindromic(String s) {
        int length = s.length();
        if(length == 1) {
            return true;
        }
        for (int i = 0; i < length / 2; i++) {
            char leftSide = s.charAt(i);
            char rightSide = s.charAt(length - i - 1);
            if (leftSide != rightSide) {
                return false;
            }
        }
        return true;
    }

}
