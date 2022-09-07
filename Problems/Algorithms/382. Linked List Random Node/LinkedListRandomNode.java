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
    private ArrayList<Integer> list = new ArrayList<>();

    public Solution(ListNode head) {
        while (head != null) {
            this.list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int id = (int) (Math.random() * this.list.size());
        return this.list.get(id);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */