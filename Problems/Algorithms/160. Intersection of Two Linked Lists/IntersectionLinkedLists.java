/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        
        while (currA != currB) {
            if (currA != null) {
                currA = currA.next;
            } else {
                currA = headB;
            }
            
            if (currB != null) {
                currB = currB.next;
            } else {
                currB = headA;
            }
        }
        
        return currA;
    }
}

