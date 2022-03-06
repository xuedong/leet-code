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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var prev: ListNode? = ListNode(0)
        prev?.next = head
        var node: ListNode? = prev
        
        while (node?.next != null) {
            if (node?.next.`val` == `val`) {
                node?.next = node?.next.next
            } else {
                node = node?.next
            }
        }
        
        return prev?.next
    }
}

