package com.leetcode.traning.containerwithmostwater;

/**
 * @author Nikolay Chechenko.
 * @since 02.05.2020
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxSquare = containerWithMostWater.maxArea(input);
        System.out.println(maxSquare);
    }

    public int maxArea(int[] height) {
        int maxSquare = 0;
        for (int i = 0; i < height.length; i++) {
            int leftWall = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = findMinHeight(leftWall, height[j]);
                int currentSquare = minHeight * (j - i);
                if (currentSquare > maxSquare) {
                    maxSquare = currentSquare;
                }
            }
        }
        return maxSquare;
    }

    private int findMinHeight(int height1, int height2) {
        return Math.min(height1, height2);
    }
}
