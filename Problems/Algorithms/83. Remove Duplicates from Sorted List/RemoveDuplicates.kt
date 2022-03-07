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
        dummy?.next = head
        var curr: ListNode? = head
        
        while (curr?.next != null) {
            if (curr?.`val` == curr?.next.`val`) {
                curr?.next = curr?.next.next
            } else {
                curr = curr?.next
            }
        }
        
        return dummy?.next
    }
}

