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
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        
        var left: ListNode? = ListNode(-101)
        var right: ListNode? = ListNode(-101)
        var start: ListNode? = null
        var mid: ListNode? = null
        
        var curr: ListNode? = head
        while (curr != null) {
            if (curr?.`val` >= x) {
                if (right?.`val` == -101) {
                    mid = curr
                }
                right?.next = curr
                right = curr
            } else {
                if (left?.`val` == -101) {
                    start = left
                }
                left?.`next` = curr
                left = curr
            }
            curr = curr?.next
        }
        left?.next = mid
        right?.next = null
        
        if (start?.next == null) return mid
        return start?.next
    }
}

