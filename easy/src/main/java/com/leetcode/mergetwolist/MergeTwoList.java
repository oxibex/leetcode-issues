package com.leetcode.mergetwolist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author Nikolay Chechenko.
 * @since 14.05.2020
 */
public class MergeTwoList {

    public static void main(String[] args) {
        MergeTwoList inst = new MergeTwoList();
        //generate test case
        ListNode nodeOne = inst.generateList(1, 2, 4);
        ListNode nodeTwo = inst.generateList(1, 3, 4);

        inst.printList(nodeOne);
        inst.printList(nodeTwo);

        System.out.println("merge");
        //do stuff  (O_o)
        ListNode resultNode = inst.mergeTwoLists(nodeOne, nodeTwo);
        inst.printList(resultNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Integer[] sortedValues = getAllSortedValuesFromBothList(l1, l2);
        return generateList(sortedValues);
    }

    private Integer[] getAllSortedValuesFromBothList(ListNode left, ListNode right) {
        List<Integer> list = new ArrayList<>();
        while (left != null || right != null) {
            if(left != null) {
                list.add(left.val);
            }
            if (right != null) {
                list.add(right.val);
            }
            left = left != null ? left.next : null;
            right = right != null ? right.next : null;
        }
        list.sort(Integer::compareTo);

        return list.toArray(new Integer[0]);
    }

    private void printList(ListNode root) {
        ListNode currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.val + ":");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    private ListNode generateList(Integer... values) {
        ListNode root = getNextNode(values, 0);
        return root;
    }

    private ListNode getNextNode(Integer[] values, int nodeIndex) {
        if (nodeIndex >= values.length) {
            return null;
        }
        ListNode nextNode = getNextNode(values, nodeIndex + 1);
        ListNode node = new ListNode(values[nodeIndex], nextNode);
        return node;
    }

}
