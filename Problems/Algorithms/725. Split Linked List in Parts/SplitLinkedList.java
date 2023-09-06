// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        int len = n / k, rest = n % k;

        ListNode[] result = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode root = new ListNode(0);
            ListNode write = root;
            for (int j = 0; j < len + (i < rest ? 1 : 0); j++) {
                write = write.next = new ListNode(curr.val);
                if (curr != null) {
                    curr = curr.next;
                }
            }
            result[i] = root.next;
        }

        return result;
    }
}
