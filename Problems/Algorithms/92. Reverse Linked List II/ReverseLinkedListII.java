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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        
        ListNode curr = head;
        ListNode prev = null;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        ListNode start = prev;
        ListNode end = curr;
        
        while (right > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            right--;
        }
        
        if (start != null) {
            start.next = prev;
        } else {
            head = prev;
        }
        end.next = curr;
        return head;
    }
}

