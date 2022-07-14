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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pivot = getPivot(head);
        ListNode left = sortList(head);
        ListNode right = sortList(pivot);
        
        return merge(left, right);
    }
    
    private ListNode getPivot(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            prev = prev == null ? head : prev.next;
            head = head.next.next;
        }
        ListNode pivot = prev.next;
        prev.next = null;
        return pivot;
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        node.next = node1 == null ? node2 : node1;
        return dummy.next;
    }
}

