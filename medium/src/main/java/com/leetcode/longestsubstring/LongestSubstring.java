package com.leetcode.longestsubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author Nikolay Chechenko.
 * @since 01.05.2020
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring instance = new LongestSubstring();
        int maxLength = instance.lengthOfLongestSubstring("1abcdaa");
        System.out.println("Max length " + maxLength);
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int index = 0;
        while (notEndOfString(s, index)) {
            int stringIndex = index;

            Set<Character> accumulator = new HashSet<>();
            char c;

            while (notEndOfString(s, stringIndex) && uniqueChar(accumulator, c = s.charAt(stringIndex))) {
                accumulator.add(c);
                stringIndex++;
            }
            if(notEndOfString(s, stringIndex)) {
                index = s.indexOf(s.charAt(stringIndex), index) + 1;
            }else {
                index = s.length();
            }

            if (accumulator.size() > maxLength) {
                maxLength = accumulator.size();
            }
        }
        return maxLength;
    }

    private boolean notEndOfString(String s, int index) {
        return index < s.length();
    }

    private boolean uniqueChar(Set<Character> accumulator, char c) {
        return !accumulator.contains(c);
    }

}
