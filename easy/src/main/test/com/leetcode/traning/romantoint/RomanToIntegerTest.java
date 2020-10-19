package com.leetcode.traning.romantoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikolay Chechenko.
 * @since 20.05.2020
 */
class RomanToIntegerTest {

    @Test
    void romanToInt() {
        RomanToInteger inst = new RomanToInteger();
        assertEquals(inst.romanToInt("III"), 3);

        assertEquals(inst.romanToInt("IV"), 4);
        assertEquals(inst.romanToInt("IX"), 9);
        assertEquals(inst.romanToInt("LVIII"), 58);
        assertEquals(inst.romanToInt("MCMXCIV"), 1994);
    }
}