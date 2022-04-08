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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1, head);
        ListNode second = new ListNode(-1, head);
        
        for (int i = 1; i <= n; i++) {
            first = first.next;
            if (first == null) {
                return null;
            }
        }
        
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        if (second.next != null) {
            second.next = second.next.next;
            if (second.val == -1) head = second.next; 
        } else {
            return null;
        }
        
        return head;
    }
}

