package com.leetcode.addtwonumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itse
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author Nikolay Chechenko.
 * @since 27.04.2020
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        AddTwoNumbers instance = new AddTwoNumbers();

        ListNode list1 = instance.buildListNode(2, 4, 3);
        ListNode list2 = instance.buildListNode(5, 6, 4);
        ListNode result = instance.addTwoNumbers(list1, list2);
        instance.printListNode(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger number1 = buildNumberFromListNode(l1);
        BigInteger number2 = buildNumberFromListNode(l2);
        System.out.println(number1);
        System.out.println(number2);
        return buildListNodeFromSum(number1.add(number2));
    }

    private BigInteger buildNumberFromListNode(ListNode listNode) {
        if(listNode == null){
            return BigInteger.ZERO;
        }
        List<Integer> arrayListFromListNode = createArrayListFromListNode(listNode);
        String numberString = buildStringFromArrayListReversed(arrayListFromListNode);
        return new BigInteger(numberString);
    }

    private List<Integer> createArrayListFromListNode(ListNode listNode) {
        ListNode leaf = listNode;
        List<Integer> listNodeValue = new ArrayList<>();
        while (leaf != null) {
            listNodeValue.add(leaf.val);
            leaf = leaf.next;
        }
        return listNodeValue;
    }

    private String buildStringFromArrayListReversed(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        int listSize = list.size();
        for (int i = listSize - 1; i >= 0 ; i--) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }

    private ListNode buildListNodeFromSum(BigInteger value) {
        String s = String.valueOf(value);
        int [] spitedValue = new int[s.length()];
        int index = 0;
        for (int i = s.length() -1; i >= 0 ; i--) {
            String oneCharString = Character.toString(s.charAt(i));
            spitedValue[index] = Integer.valueOf(oneCharString);
            index++;
        }
        return buildListNode(spitedValue);
    }

    private ListNode buildListNode(int... input) {
        ListNode head = null;
        ListNode parent = null;
        for (int i = 0; i < input.length; i++) {
            if (head == null) {
                head = new ListNode(input[i]);
                parent = head;
            } else {
                ListNode childNode = new ListNode(input[i]);
                parent.next = childNode;
                parent = childNode;
            }
        }
        return head;
    }

    private void printListNode(ListNode listNode) {
        ListNode leaf = listNode;
        while (leaf != null) {
            System.out.print(leaf.val);
            if(leaf.next != null) {
                System.out.print(" -> ");
            }
            leaf = leaf.next;
        }
    }

}
