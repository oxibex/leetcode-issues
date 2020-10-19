package com.leetcode.traning.addtwonumbers;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author Nikolay Chechenko.
 * @since 30.04.2020
 */
public class AddTowNumbersSecondIssue {

    private final int BORDER_VALUE = 10;

    public static void main(String[] args) {
        AddTowNumbersSecondIssue instance = new AddTowNumbersSecondIssue();
        ListNode list1 = instance.buildListNode(2, 4, 3);
        ListNode list2 = instance.buildListNode(5, 6, 4);
        ListNode result = instance.addTwoNumbers(list1, list2);
        instance.printListNode(result);
    }

    /**
     * 342
     * 465
     * ---
     * 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1Node = l1;
        ListNode list2Nome = l2;

        boolean carry = false;
        ListNode rootNode = null;
        ListNode currentNode = null;
        while (anyNotIsNotNull(list1Node, list2Nome) || carry) {
            int valListNode1 = list1Node != null ? list1Node.val : 0;
            int valListNode2 = list2Nome != null ? list2Nome.val : 0;
            int extraValue = carry ? 1 : 0;

            int addTowNumberResult = valListNode1 + valListNode2 + extraValue;
            carry = addTowNumberResult >= BORDER_VALUE;
            if (carry) {
                addTowNumberResult = addTowNumberResult % BORDER_VALUE;
            }

            if (rootNode == null) {
                //create parent node
                rootNode = new ListNode(addTowNumberResult);
                currentNode = rootNode;
            } else {
                ListNode newChild = new ListNode(addTowNumberResult);
                currentNode.next = newChild;
                currentNode = newChild;
            }

            list1Node = list1Node != null ? list1Node.next : null;
            list2Nome = list2Nome != null ? list2Nome.next : null;
        }

        return rootNode;
    }

    private boolean anyNotIsNotNull(ListNode l1, ListNode l2) {
        return l1 != null || l2 != null;
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
            if (leaf.next != null) {
                System.out.print(" -> ");
            }
            leaf = leaf.next;
        }
    }
}
