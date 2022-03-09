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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var dummy: ListNode? = ListNode(0)
        var curr: ListNode? = head
        var prev: ListNode? = dummy
        
        while (curr != null) {
            if (curr?.`val` == curr?.next?.`val`) {
                while (curr?.`val` == curr?.next?.`val`) {
                    curr = curr?.next
                }
            } else {
                prev?.next = curr
                prev = curr
            }
            curr = curr?.next
        }
        prev?.next = curr
        
        return dummy?.next
    }
}

