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
        var curr: ListNode? = head
        var prev: ListNode? = null
        var temp: ListNode? = null
        
        while (curr != null) {
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        }
        
        return prev
    }
}

