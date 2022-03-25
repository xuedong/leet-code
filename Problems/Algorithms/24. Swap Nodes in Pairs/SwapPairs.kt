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
    fun swapPairs(head: ListNode?): ListNode? {
        return swap(head, head?.next)
    }
    
    private fun swap(node1: ListNode?, node2: ListNode?): ListNode? {
        if (node1 == null) return null
        if (node2 == null) return node1
        
        val next: ListNode? = node2.next
        node2.next = node1
        node1.next = swap(next, next?.next)
        
        return node2
    }
}

