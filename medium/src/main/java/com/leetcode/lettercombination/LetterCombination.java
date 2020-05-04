package com.leetcode.lettercombination;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author Nikolay Chechenko.
 * @since 04.05.2020
 */
public class LetterCombination {

    private final Map<String, Set<Character>> phoneKeyboard = Map.of(
            "2", Set.of('a', 'b', 'c'),
            "3", Set.of('d', 'e', 'f'),
            "4", Set.of('g', 'h', 'i'),
            "5", Set.of('j', 'k', 'l'),
            "6", Set.of('m', 'n', 'o'),
            "7", Set.of('p', 'q', 'r', 's'),
            "8", Set.of('t', 'u', 'v'),
            "9", Set.of('w', 'x', 'y', 'z')
    );

    public static void main(String[] args) {
        LetterCombination instance = new LetterCombination();
        System.out.println(instance.letterCombinations("235"));
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        String key = digits.substring(0, 1);
        String tail = digits.length() == 1 ? null : digits.substring(1);

        List<String> tailVariants = letterCombinations(tail);
        List<String> res = new ArrayList<>();
        Set<Character> characters = phoneKeyboard.get(key);
        for (Character c : characters) {
            String oneCharValue = Character.toString(c);
            if (tailVariants != null && !tailVariants.isEmpty()) {
                for (String variant : tailVariants) {
                    res.add(oneCharValue + variant);
                }
            } else {
                res.add(oneCharValue);
            }
        }
        return res;
    }

}
