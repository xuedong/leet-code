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
    fun middleNode(head: ListNode?): ListNode? {
        var fast: ListNode? = head
        var slow: ListNode? = head
        
        while (fast != null && fast?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
        }
        
        return slow
    }
}

