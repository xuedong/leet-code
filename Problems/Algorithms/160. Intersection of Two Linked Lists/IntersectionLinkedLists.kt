/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currA: ListNode? = headA
        var currB: ListNode? = headB
        
        while (currA != currB) {
            if (currA != null) {
                currA = currA?.next
            } else {
                currA = headB
            }
            
            if (currB != null) {
                currB = currB?.next
            } else {
                currB = headA
            }
        }
        
        return currA
    }
}

