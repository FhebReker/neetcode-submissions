/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize node to build off of and carry num
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;

        // Loop until all numbers have been accounted for
        while (l1 != null || l2 != null || carry != 0) {
            // Set up current digits
            int dig1 = (l1 != null) ? l1.val : 0;
            int dig2 = (l2 != null) ? l2.val : 0;

            // Find digit, then adjust carry
            int sum = dig1 + dig2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // Set the next node to the new digit, then move to the next node
            ListNode temp = new ListNode(digit);
            tail.next = temp;
            tail = tail.next;

            // Adjust l1 and l2 as necessary
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // Move from the base node to the actual node used, and return it
        ListNode trueHead = head.next;
        head.next = null;
        return trueHead;
    }
}
