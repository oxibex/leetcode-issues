package com.leetcode.traning.climbingstairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikolay Chechenko.
 * @since 19.10.2020
 */
class ClimbingStairsTest {

    @Test
    void climbingTest() {

        ClimbingStairs impl = new ClimbingStairs();

        assertEquals(2, impl.climbStairs(2));
        assertEquals(3, impl.climbStairs(3));
        assertEquals(89, impl.climbStairs(10));
        assertEquals(1134903170, impl.climbStairs(44));

    }
}