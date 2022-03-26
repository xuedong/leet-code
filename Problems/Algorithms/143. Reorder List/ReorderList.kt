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
    fun reorderList(head: ListNode?): Unit {
        var slow: ListNode? = head
        var fast: ListNode? = head
        
        while (fast?.next != null && fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        
        var curr1: ListNode? = head
        var curr2: ListNode? = reverseList(slow?.next)
        slow?.next = null
        
        val dummy: ListNode? = ListNode(-1)
        var curr: ListNode? = dummy
        while (curr1 != null && curr2 != null) {
            curr?.next = curr1
            curr1 = curr1.next
            curr = curr?.next
        
            curr?.next = curr2
            curr2 = curr2.next
            curr = curr?.next
        }
        
        if (curr1 != null) curr?.next = curr1
    }
    
    private fun reverseList(head: ListNode?): ListNode? {
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

