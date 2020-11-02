package linkedlist;

import java.util.Objects;

public class AddTwoNumbers {

    /* Description
    * You are given two non-empty linked lists representing two non-negative integers.
    * The digits are stored in reverse order, and each of their nodes contains a single digit.
    * Add the two numbers and return the sum as a linked list.
    *
    * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    * */

    /* Data Sturture: LinkedList */

    /* Time Complexity: O(n) - Linear
    * Where n is the number of the larger ListNode */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = Objects.nonNull(l1) ? l1.val : 0;
            int l2Val = Objects.nonNull(l2) ? l2.val : 0;
            int sum = l1Val + l2Val + carry;

            carry = sum > 9 ? sum / 10 : 0;
            head.next = new ListNode(sum % 10);
            head = head.next;

            if (Objects.nonNull(l1)) l1 = l1.next;
            if (Objects.nonNull(l2)) l2 = l2.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }

    /* Demonstration */
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = createListNode(new int[] { 2, 4, 3 });
        ListNode l2 = createListNode(new int[] { 5, 6, 4 });
        ListNode result = solution.addTwoNumbers(l1, l2);

        while(result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

    private static ListNode createListNode(int[] nums) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        for (int num: nums) {
            head.next = new ListNode(num);
            head = head.next;
        }

        return listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
