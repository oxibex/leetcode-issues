package com.leetcode.traning.symmetrictree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author Nikolay Chechenko.
 * @since 03.05.2020
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree instance = new SymmetricTree();
        TreeNode summetricTree = instance.getSymmetricTree();

        boolean symmetric = instance.isSymmetric(summetricTree);
        System.out.println("is symmetric " + symmetric);

        TreeNode unSymmetricTree = instance.getUnSymmetricTree();

        symmetric = instance.isSymmetric(unSymmetricTree);
        System.out.println("is symmetric " + symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return compareNodes(left, right);
    }

    private boolean compareNodes(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        Integer leftVal = left != null ? left.val : null;
        Integer rightVal = right != null ? right.val : null;

        boolean res = leftVal == rightVal;

        if(res) {
            res = compareNodes(left.left, right.right);
            if(res) {
                res = compareNodes(left.right, right.left);
            }
        }
        return res;
    }

    private TreeNode getSymmetricTree() {
        TreeNode leftChild = getChildNode(2, 3, 4);
        TreeNode rightChild = getChildNode(2, 4, 3);
        return new TreeNode(1, leftChild, rightChild);
    }

    private TreeNode getUnSymmetricTree() {
        TreeNode leftChild = getChildNode(2, null, 3);
        TreeNode rightChild = getChildNode(2, null, 3);
        return new TreeNode(1, leftChild, rightChild);
    }

    private TreeNode getChildNode(int parentValue, Integer leftValue, Integer rightValue) {
        TreeNode left = leftValue != null ? new TreeNode(leftValue) : null;
        TreeNode right = rightValue != null ? new TreeNode(rightValue) : null;
        TreeNode parent = new TreeNode(parentValue, left, right);
        return parent;
    }

}
