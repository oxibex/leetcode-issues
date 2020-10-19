package com.leetcode.traning.longestpalindromic;

/**
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author Nikolay Chechenko.
 * @since 05.05.2020
 */
public class LongestPalindromicBetterIssue {

    public static void main(String[] args) {
        LongestPalindromicBetterIssue instance = new LongestPalindromicBetterIssue();

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
        for (int i = s.length(); i >= 1; i--) {
            int sizeLimit = s.length() - i;
            for (int j = 0; j <= sizeLimit; j++) {
                String variant = s.substring(j, j + i);
                if (isPalindromic(variant)) {
                    return variant;
                }
            }
        }
        return "";
    }

    private boolean isPalindromic(String s) {
        int length = s.length();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
