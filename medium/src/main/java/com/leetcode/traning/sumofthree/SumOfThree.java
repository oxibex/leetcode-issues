package com.leetcode.traning.sumofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Nikolay Chechenko.
 * @since 07.05.2020
 */
public class SumOfThree {

    public static void main(String[] args) {
        SumOfThree instance = new SumOfThree();
//        int[] test2 = {-1, 0, 1, 2, -1, -4};
        int[] test2 = {-1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3};

        List<List<Integer>> list = instance.threeSum(test2);
        list.stream().forEach(System.out::println);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int firstElement = nums[i];
            if (firstElement > 0) {
                break;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                int secondElement = nums[j];
                if (firstElement + secondElement > 0) {
                    break;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] + firstElement + secondElement == 0) {
                        result.add(Arrays.asList(nums[k], firstElement, secondElement));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
