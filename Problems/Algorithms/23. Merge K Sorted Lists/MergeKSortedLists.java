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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2){
                if (node1.val < node2.val) {
                    return -1;
                } else if (node1.val == node2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            node.next = curr;
            node = node.next;
            
            curr = curr.next;
            if (curr != null) {
                pq.offer(curr);
            }
        }
        
        return dummy.next;
    }
}
