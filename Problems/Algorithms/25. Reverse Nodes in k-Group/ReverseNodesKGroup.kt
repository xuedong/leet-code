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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k < 2) return head
        
        var lastTail: ListNode? = null
        var lastHead: ListNode? = null
        var prev: ListNode? = null
        var curr: ListNode? = head
        var ans: ListNode? = head
        
        var count = 1
        var i = 1

        while (curr != null) {
            if (i == 1) {
                prev = curr
                lastHead = prev
            }
            
            curr = curr?.next
            count++
            i++
            
            if (curr == null) {
                break
            }
            
            if (count == k) {
                ans = curr
            }
            
            if (i == k) {
                var next = curr?.next
                var iter = prev?.next
                prev?.next = next
                while (iter != next) {
                    var temp = iter?.next
                    iter?.next = prev
                    prev = iter
                    iter = temp
                }

                if (lastTail != null) {
                    lastTail?.next = prev
                }
                lastTail = lastHead
                curr = next
                i = 1
            }
        }

        return ans
    }
}

