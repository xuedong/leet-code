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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        
        ListNode lastTail = null;
        ListNode lastHead = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ans = head;
        
        int count = 1;
        int i = 1;

        while (curr != null) {
            if (i == 1) {
                prev = curr;
                lastHead = prev;
            }
            
            curr = curr.next;
            count++;
            i++;
            
            if (curr == null) {
                break;
            }
            
            // To find the head of the final output
            if (count == k) {
                ans = curr;
            }
            
            if (i == k) {
                ListNode next = curr.next;
                ListNode iter = prev.next;
                prev.next = next;
                while (iter != next) {
                    ListNode temp = iter.next;
                    iter.next = prev;
                    prev = iter;
                    iter = temp;
                }

                if (lastTail != null) {
                    lastTail.next = prev;
                }
                lastTail = lastHead;
                curr = next;
                i = 1;
            }
        }

        return ans;
    }
}

