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
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (k == 1) {
            var tail: ListNode? = head
            while (tail?.next != null) {
                tail = tail?.next
            }
            head?.`val` = tail?.`val`.also { tail?.`val` = head?.`val` }
            
            return head
        }
        
        var left: ListNode? = head
        for (i in 0..k-2) {
            left = left?.next
        }
        
        var tail: ListNode? = left
        var right: ListNode? = head
        while (tail?.next != null) {
            right = right?.next
            tail = tail?.next
        }
        
        left?.`val` = right?.`val`.also { right?.`val` = left?.`val` }
        
        return head
    }
}

