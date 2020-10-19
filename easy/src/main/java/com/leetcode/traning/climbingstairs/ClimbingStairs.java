package com.leetcode.traning.climbingstairs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nikolay Chechenko.
 * @since 19.10.2020
 * <p>
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    //Stair step count -> Valid paths count
    Map<Integer, Integer> stepResult = new ConcurrentHashMap<>();

    public int climbStairs(int n) {
        int step = n;
        if (stepResult.containsKey(step)) {
            return stepResult.get(step);
        }
        if (step == 0) {
            return 1;
        }

        int variants = climbStairs(step - 1);
        if (step > 1) {
            variants += climbStairs(step - 2);
        }
        //store valid paths count result for exceed over calculation
        stepResult.putIfAbsent(step, variants);
        return variants;
    }

}
