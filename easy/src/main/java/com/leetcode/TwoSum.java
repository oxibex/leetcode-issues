package com.leetcode;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Nikolay Chechenko.
 * @since 27.04.2020
 */
public class TwoSum {

    private static final int TARGET = 9;

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        TwoSum instance = new TwoSum();
        int[] result = instance.twoSum(input, TARGET);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int firstElement = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    //pass the same element
                    continue;
                }
                int secondElement = nums[j];
                if (firstElement + secondElement == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }
}
