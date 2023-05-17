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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        List<Integer> nums = new ArrayList<>();

        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }

        int n = nums.size();
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < j) {
            ans = Math.max(ans, nums.get(i) + nums.get(j));
            i++;
            j--;
        }

        return ans;
    }
}
