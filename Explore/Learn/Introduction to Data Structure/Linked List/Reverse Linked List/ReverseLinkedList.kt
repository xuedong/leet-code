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
    fun reverseList(head: ListNode?): ListNode? {
        var current: ListNode? = head
        var prev: ListNode? = null
        var temp: ListNode? = null
        
        while (current != null) {
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        
        return prev
    }
}

