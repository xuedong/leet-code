// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy;

        while (start != null) {
            int prefix = 0;
            ListNode end = start.next;

            while (end != null) {
                prefix += end.val;
                if (prefix == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }

            start = start.next;
        }

        return dummy.next;
    }
}
