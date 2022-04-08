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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first: ListNode? = ListNode(-1)
        first?.next = head
        var second: ListNode? = ListNode(-1)
        second?.next = head
        var dummy: ListNode? = head
        
        for (i in 0..n-1) {
            first = first?.next
            if (first == null) {
                return null
            }
        }
        
        while (first?.next != null) {
            first = first?.next
            second = second?.next
        }
        
        if (second?.next != null) {
            second?.next = second?.next?.next
            if (second?.`val` == -1) {
                dummy = second?.next
            }
        }
        
        return dummy
    }
}

