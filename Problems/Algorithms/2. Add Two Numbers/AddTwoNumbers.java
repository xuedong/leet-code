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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node3 = ans;
        int carry = 0;
        
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            node3.val = sum % 10;
            carry = sum / 10;
            
            if (node1.next == null && node2.next == null) {
                if (carry == 1) {
                    node3.next = new ListNode(1);
                }
                return ans;
            }
            
            node3.next = new ListNode(0);
            node3 = node3.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        
        while (node1 != null) {
            int sum = node1.val + carry;
            node3.val = sum % 10;
            carry = sum / 10;
            
            if (node1.next == null) {
                if (carry == 1) {
                    node3.next = new ListNode(1);
                }
                return ans;
            }
            
            node3.next = new ListNode(0);
            node3 = node3.next;
            node1 = node1.next;
        }
        
        while (node2 != null) {
            int sum = node2.val + carry;
            node3.val = sum % 10;
            carry = sum / 10;
            
            if (node2.next == null) {
                if (carry == 1) {
                    node3.next = new ListNode(1);
                }
                return ans;
            }
            
            node3.next = new ListNode(0);
            node3 = node3.next;
            node2 = node2.next;
        }
        
        return ans;
    }
}

