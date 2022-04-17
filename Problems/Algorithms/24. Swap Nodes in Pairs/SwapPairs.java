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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        return swap(head, head.next);
    }
    
    private ListNode swap(ListNode node1, ListNode node2) {
        if (node1 == null) return null;
        if (node2 == null) return node1;
        
        ListNode next = node2.next;
        node2.next = node1;
        if (next != null) node1.next = swap(next, next.next);
        else node1.next = swap(next, null);
        
        return node2;
    }
}

