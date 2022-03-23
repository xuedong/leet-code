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
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        var flag = false
        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast) {
                flag = true
                break
            }
        }
        
        if (flag) {
            var curr = head
            while (curr != slow) {
                curr = curr?.next
                slow = slow?.next
            }
            return curr
        }
        
        return null
    }
}

