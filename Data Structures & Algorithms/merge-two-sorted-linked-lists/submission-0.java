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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Initializing Variables
        ListNode head = new ListNode(0);
        ListNode current = head;

        // Loop until one of the lists are empty
        while(list1 != null && list2 != null){
            // Add list1 node to list if lower
            if (list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            // Add list2 node to list if lower
            else{
                current.next = list2;
                list2 = list2.next;
            }

            // Move onto next list node
            current = current.next;
        }

        // Depending on which list has remaining nodes (if any), set next node to list node
        if (list1 != null){current.next = list1;}
        if (list2 != null){current.next = list2;}

        // Return the head of the merged list
        return head.next;
    }
}