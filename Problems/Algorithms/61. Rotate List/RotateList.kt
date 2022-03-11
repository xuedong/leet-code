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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        
        val dummy = ListNode(-1)
        dummy.next = head
        var last: ListNode? = dummy
        var len = 0
        while (last?.next != null) {
            last = last?.next
            len++
        }
        
        if (k % len == 0) return head
        var curr: ListNode? = dummy
        var i = 1
        while (i <= len - k % len) {
            curr = curr?.next
            i++
        }
        val temp = curr?.next
        curr?.next = null
        last?.next = head
        return temp
    }
}

